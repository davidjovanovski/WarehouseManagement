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

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    private int totalPrice;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    private LocalDate createdAt;

    public Order(int invoiceNumber, List<OrderItem> items, int totalPrice, Status status, LocalDate createdAt, User user){
        this.invoiceNumber = invoiceNumber;
        this.items = items;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = createdAt;
        this.user = user;
    }
}
