package re.edu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.edu.dto.request.ProductAdd;
import re.edu.dto.request.ProductUpdate;
import re.edu.dto.response.PageDto;
import re.edu.dto.response.ProductDto;
import re.edu.entity.Product;
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
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id){
        try {
            return ResponseEntity.ok(productService.getById(id));

        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@ModelAttribute ProductAdd request){
        return ResponseEntity.ok(productService.create(request));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@ModelAttribute ProductUpdate request){
       try{
           return ResponseEntity.ok(productService.update(request, id));
       }catch (RuntimeException e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }
    } @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            productService.deleteById(id);
            return ResponseEntity.noContent().build();
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
