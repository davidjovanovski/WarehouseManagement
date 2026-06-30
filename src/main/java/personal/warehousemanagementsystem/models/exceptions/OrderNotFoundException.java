package personal.warehousemanagementsystem.models.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super(String.format("Order with id: %d doesn't exist", id));
    }
}
