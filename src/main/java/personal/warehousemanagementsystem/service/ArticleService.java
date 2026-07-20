package personal.warehousemanagementsystem.service;

import personal.warehousemanagementsystem.models.Article;

import java.util.List;

public interface ArticleService {
    List<Article> listArticles();

    Article findById(Long id);

    Article create(String title, String barcode, int price, int quantity, Long companyId, Long categoryId);

    Article update(Long id, String title, int price, int quantity, Long companyId, Long categoryId);

    void delete(Long id);
}
