package re.edu.dto.response;

import lombok.Data;

@Data
public class ProductDto {
    private int productID;
    private String name;
    private double price;
    private String category;
    private String brand;
    private String imageURL;
}
