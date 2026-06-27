package personal.warehousemanagementsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "article_id")
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
