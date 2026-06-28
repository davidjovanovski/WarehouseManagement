package personal.warehousemanagementsystem.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    private int quantity;
    private int price;

    public OrderItem(Order order, Article article, int quantity, int price){
        this.order = order;
        this.article = article;
        this.quantity = quantity;
        this.price = price;
    }
}
