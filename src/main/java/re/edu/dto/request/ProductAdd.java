package re.edu.dto.request;

import lombok.Data;

@Data
public class ProductAdd {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String category;
    private String brand;
    private String imageURL;
}
