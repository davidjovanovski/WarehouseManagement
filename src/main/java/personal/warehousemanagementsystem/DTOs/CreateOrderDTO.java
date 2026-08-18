package personal.warehousemanagementsystem.DTOs;

import lombok.Data;
import personal.warehousemanagementsystem.models.enums.Status;

import java.util.List;

@Data
public class CreateOrderDTO {

    private int invoiceNumber;
    private Status status;
    List<OrderItemDTO> items;

}
