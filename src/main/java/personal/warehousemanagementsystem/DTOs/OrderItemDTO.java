package personal.warehousemanagementsystem.DTOs;

import lombok.Data;

@Data
public class OrderItemDTO {

    private Long articleId;
    private int quantity;
    private int price;

}
