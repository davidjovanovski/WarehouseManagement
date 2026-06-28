package personal.warehousemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.warehousemanagementsystem.models.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitle(String title);

    Optional<Article> findByBarcode(String barcode);
}
