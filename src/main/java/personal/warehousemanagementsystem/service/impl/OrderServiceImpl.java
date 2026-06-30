package personal.warehousemanagementsystem.service.impl;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import personal.warehousemanagementsystem.models.Order;
import personal.warehousemanagementsystem.models.OrderItem;
import personal.warehousemanagementsystem.models.User;
import personal.warehousemanagementsystem.models.enums.Status;
import personal.warehousemanagementsystem.models.exceptions.OrderNotFoundException;
import personal.warehousemanagementsystem.repository.OrderRepository;
import personal.warehousemanagementsystem.repository.UserRepository;
import personal.warehousemanagementsystem.service.OrderService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {


    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository){
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Order> listOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findOrdersByUser(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        return orderRepository.findOrdersByUser(user);
    }

    @Override
    public List<Order> findOrdersByStatus(Status status) {
        return orderRepository.findOrderByStatus(status);
    }

    @Override
    public Optional<Order> findOrdersByInvoiceNumber(int invoiceNumber) {
        return orderRepository.findOrderByInvoiceNumber(invoiceNumber);
    }

    @Override
    public List<Order> findOrdersByDate(LocalDate date) {
        return orderRepository.findOrderByCreatedAt(date);
    }

    @Override
    public List<Order> findOrdersByDateBetween(LocalDate start, LocalDate end) {
        return orderRepository.findOrderByCreatedAtBetween(start, end);
    }

    @Override
    public Order create(String username, int invoiceNumber, List<OrderItem> items, Status status) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        Order order = new Order(user, invoiceNumber, items, status);
        return orderRepository.save(order);
    }

    @Override
    public Order update(Long id, List<OrderItem> items, Status status) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        order.setItems(items);
        order.setStatus(status);
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
