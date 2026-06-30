package personal.warehousemanagementsystem.service;

import org.springframework.stereotype.Service;
import personal.warehousemanagementsystem.models.Article;
import personal.warehousemanagementsystem.models.Category;
import personal.warehousemanagementsystem.models.Company;

import java.util.List;

@Service
public interface ArticleService {
    List<Article> listArticles();

    List<Article> searchArticles();

    Article findById(Long id);

    Article create(String title, String barcode, int price, int quantity, Company company, Category category);

    Article update(String title, int price, int quantity, Company company, Category category);

    void delete(Long id);
}
