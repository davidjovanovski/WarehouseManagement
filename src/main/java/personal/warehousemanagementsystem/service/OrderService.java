package personal.warehousemanagementsystem.service;

import personal.warehousemanagementsystem.DTOs.OrderItemDTO;
import personal.warehousemanagementsystem.models.Order;
import personal.warehousemanagementsystem.models.OrderItem;
import personal.warehousemanagementsystem.models.enums.Status;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> listOrders(String username, Status status, LocalDate start, LocalDate end);

    Optional<Order> findOrdersByInvoiceNumber(int invoiceNumber);

    Order create(String username, int invoiceNumber, List<OrderItemDTO> items, Status status);

    Order update(Long id, List<OrderItem> items, Status status);

    void delete(Long id);
}
