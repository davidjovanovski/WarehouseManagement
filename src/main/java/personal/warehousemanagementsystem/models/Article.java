package personal.warehousemanagementsystem.models;

import jakarta.persistence.*;
import lombok.*;
import personal.warehousemanagementsystem.models.enums.Status;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(nullable = false, unique = true)
    private String barcode;

    private int price;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Article(String title, String barcode, int price, int quantity, Company company, Category category) {
        this.title = title;
        this.barcode = barcode;
        this.price = price;
        this.quantity = quantity;
        this.company = company;
        this.category = category;
    }
}
