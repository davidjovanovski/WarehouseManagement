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

    @Column(nullable = false, unique = true)
    private String barcode;

    private Integer price;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Article(String title, Integer price, Integer quantity, Company company){
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.company = company;
    }
}
