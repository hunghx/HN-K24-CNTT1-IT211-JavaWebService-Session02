package re.edu.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import re.edu.dto.response.PageDto;
import re.edu.dto.response.ProductDto;
import re.edu.entity.Product;
import re.edu.repository.ProductRepository;

import java.util.List;

@Service // Controller, Service, Repository <<< Component để tạo bean
@RequiredArgsConstructor
public class ProductService {
    // DI
//    @Autowired
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
//    public ProductService(ProductRepository productRepository){
//        this.productRepository = productRepository;
//    }

//    public void setProductRepository(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
    /*
    trả về danh sách của trang đấy và thông tin : trang hiện tại, số lượng phần tử
    tổng s trang, tổng số phần tử (ops)
     */
    public PageDto<ProductDto> getAllProductPagination(Pageable pageable){
        Page<Product> page = productRepository.findAll(pageable);
        PageDto<ProductDto> pageDto = PageDto.<ProductDto>builder()
                .page(page.getNumber())
                .size(page.getSize())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .data(page.getContent().stream().map(this::mapToDto).toList())
                .build();
        return pageDto;
    }
    private ProductDto mapToDto(Product p){
        return modelMapper.map(p, ProductDto.class);
    }
}
