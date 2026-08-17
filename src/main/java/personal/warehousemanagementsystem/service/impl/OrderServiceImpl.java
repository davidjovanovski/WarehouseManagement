package personal.warehousemanagementsystem.service.impl;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import personal.warehousemanagementsystem.DTOs.OrderItemDTO;
import personal.warehousemanagementsystem.models.Article;
import personal.warehousemanagementsystem.models.Order;
import personal.warehousemanagementsystem.models.OrderItem;
import personal.warehousemanagementsystem.models.User;
import personal.warehousemanagementsystem.models.enums.Status;
import personal.warehousemanagementsystem.models.exceptions.ArticleNotFoundException;
import personal.warehousemanagementsystem.models.exceptions.OrderNotFoundException;
import personal.warehousemanagementsystem.repository.ArticleRepository;
import personal.warehousemanagementsystem.repository.OrderRepository;
import personal.warehousemanagementsystem.repository.UserRepository;
import personal.warehousemanagementsystem.service.OrderFilterSpecification;
import personal.warehousemanagementsystem.service.OrderService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ArticleRepository articleRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, ArticleRepository articleRepository){
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Order> listOrders(String username, Status status, LocalDate start, LocalDate end) {
        return orderRepository.findAll(OrderFilterSpecification.filter(username, status, start, end));
    }

    @Override
    public Optional<Order> findOrdersByInvoiceNumber(int invoiceNumber) {
        return orderRepository.findOrderByInvoiceNumber(invoiceNumber);
    }

    @Override
    public Order create(String username, int invoiceNumber, List<OrderItemDTO> items, Status status) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        List<OrderItem> orderItems = items.stream().map(dto -> {
            Article article = articleRepository.findById(dto.getArticleId()).orElseThrow( () -> new ArticleNotFoundException(dto.getArticleId()));
            return new OrderItem(null, article, dto.getQuantity(), dto.getPrice());
        }).toList();

        Order order = new Order(user,invoiceNumber, orderItems, status);
        return orderRepository.save(order);
    }

    @Override
    public Order update(Long id, List<OrderItem> items, Status status) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        order.setItems(items);
        order.setStatus(status);
        order.setTotalPrice(items.stream().mapToInt(item -> item.getQuantity() * item.getPrice()).sum());
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
