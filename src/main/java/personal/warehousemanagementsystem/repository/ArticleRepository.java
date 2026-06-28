package personal.warehousemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import personal.warehousemanagementsystem.models.Article;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByTitle(String title);

    Optional<Article> findByBarcode(String barcode);

    List<Article> findByCompanyName(String name);

    List<Article> findByCategoryName(String name);

    List<Article> findByQuantityGreaterThan(int quantity);
}
