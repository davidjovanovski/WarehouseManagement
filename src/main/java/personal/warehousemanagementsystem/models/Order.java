package personal.warehousemanagementsystem.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import personal.warehousemanagementsystem.models.enums.Status;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, unique = true)
    private int invoiceNumber;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items;

    private int totalPrice;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    private LocalDate createdAt;

    public Order(User user, int invoiceNumber, List<OrderItem> items, Status status){
        this.invoiceNumber = invoiceNumber;
        this.items = items;
        this.status = status;
        this.user = user;
        this.totalPrice = items.stream().mapToInt(item -> item.getQuantity() * item.getPrice()).sum();
    }
}