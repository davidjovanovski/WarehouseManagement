package personal.warehousemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import personal.warehousemanagementsystem.models.Order;
import personal.warehousemanagementsystem.models.enums.Status;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByInvoiceNumber(int invoiceNumber);

    Optional<Order> findByCreatedAtBetween(LocalDate start, LocalDate end);

    List<Order> findByStatus(Status status);
}
