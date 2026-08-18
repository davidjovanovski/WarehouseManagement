package personal.warehousemanagementsystem.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import personal.warehousemanagementsystem.DTOs.CreateOrderDTO;
import personal.warehousemanagementsystem.models.Order;
import personal.warehousemanagementsystem.models.User;
import personal.warehousemanagementsystem.models.enums.Status;
import personal.warehousemanagementsystem.service.OrderService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> listOrders(@RequestParam(required = false) String username,
                                  @RequestParam(required = false) Status status,
                                  @RequestParam(required = false) LocalDate start,
                                  @RequestParam(required = false) LocalDate end){
        return orderService.listOrders(username, status, start, end);
    }

    @GetMapping("/{invoiceNumber}")
    public Optional<Order> getOrder(@PathVariable int invoiceNumber){
        return orderService.findOrdersByInvoiceNumber(invoiceNumber);
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody CreateOrderDTO dto, @AuthenticationPrincipal User user){
        Order order = orderService.create(user.getUsername(), dto.getInvoiceNumber(), dto.getItems(), dto.getStatus());
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id,
                                        @RequestBody CreateOrderDTO dto){
        Order order = orderService.update(id, dto.getItems(), dto.getStatus());
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
