package personal.warehousemanagementsystem.service;

import personal.warehousemanagementsystem.models.Order;
import personal.warehousemanagementsystem.models.OrderItem;
import personal.warehousemanagementsystem.models.enums.Status;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> listOrders();

    List<Order> findOrdersByUser(String username);

    List<Order> findOrdersByStatus(Status status);

    Optional<Order> findOrdersByInvoiceNumber(int invoiceNumber);

    List<Order> findOrdersByDate(LocalDate date);

    List<Order> findOrdersByDateBetween(LocalDate start, LocalDate end);

    Order create(String username, int invoiceNumber, List<OrderItem> items, Status status);

    Order update(Long id, List<OrderItem> items, Status status);

    void delete(Long id);
}
