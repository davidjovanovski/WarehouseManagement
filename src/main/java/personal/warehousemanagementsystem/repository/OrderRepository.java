package personal.warehousemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import personal.warehousemanagementsystem.models.Order;
import personal.warehousemanagementsystem.models.User;
import personal.warehousemanagementsystem.models.enums.Status;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
    Optional<Order> findOrderByInvoiceNumber(int invoiceNumber);

    List<Order> findOrderByCreatedAt(LocalDate date);

    List<Order> findOrderByCreatedAtBetween(LocalDate start, LocalDate end);

    List<Order> findOrderByStatus(Status status);

    List<Order> findOrdersByUser(User user);
}
