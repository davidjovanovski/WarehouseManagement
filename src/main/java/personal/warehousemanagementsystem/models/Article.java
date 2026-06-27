package personal.warehousemanagementsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private Integer price;
    private Integer quantity;

    @ManyToOne
    private Company company;

    public Article(String title, Integer price, Integer quantity, Company company){
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.company = company;
    }
}
