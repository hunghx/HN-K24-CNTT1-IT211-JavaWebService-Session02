package re.edu.dto.request;

import lombok.Data;

@Data
public class ProductUpdate {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String category;
    private String brand;
    private String imageURL;
    private String status;
}
