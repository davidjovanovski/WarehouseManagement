package personal.warehousemanagementsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, unique = true)
    private int invoice_number;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    private int total_price;

    private LocalDateTime created_at;

    public Order(int invoice_number, List<OrderItem> items, int total_price, LocalDateTime created_at, User user){
        this.invoice_number = invoice_number;
        this.items = items;
        this.total_price = total_price;
        this.created_at = created_at;
        this.user = user;
    }
}
