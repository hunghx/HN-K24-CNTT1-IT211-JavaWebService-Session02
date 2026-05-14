package re.edu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import re.edu.dto.response.PageDto;
import re.edu.dto.response.ProductDto;
import re.edu.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    // Lấy danh sách thông tin có phân trang

    @GetMapping
    public ResponseEntity<PageDto<ProductDto>> getProductsByPagination(@PageableDefault(
            page = 0,
            size = 10,
            sort = {"productID"},
            direction = Sort.Direction.ASC
    ) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProductPagination(pageable));
    }


    // Các chức năng còn lại
    // Lấy thông tin theo ID : check tồn tai : trả về 404 -NOT FOUND
    // Xóa thành công : 200 (xóa hẳn và trả về dữ liệu), 204 (ko trả về body)

}
