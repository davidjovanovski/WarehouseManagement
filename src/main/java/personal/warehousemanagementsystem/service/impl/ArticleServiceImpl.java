package personal.warehousemanagementsystem.service.impl;

import org.springframework.stereotype.Service;
import personal.warehousemanagementsystem.models.Article;
import personal.warehousemanagementsystem.models.Category;
import personal.warehousemanagementsystem.models.Company;
import personal.warehousemanagementsystem.models.exceptions.ArticleNotFoundException;
import personal.warehousemanagementsystem.repository.ArticleRepository;
import personal.warehousemanagementsystem.service.ArticleService;
import personal.warehousemanagementsystem.service.CategoryService;
import personal.warehousemanagementsystem.service.CompanyService;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final CategoryService categoryService;
    private final CompanyService companyService;

    public ArticleServiceImpl(ArticleRepository articleRepository, CategoryService categoryService, CompanyService companyService){
        this.articleRepository = articleRepository;
        this.categoryService = categoryService;
        this.companyService = companyService;
    }

    @Override
    public List<Article> listArticles() {
        return this.articleRepository.findAll();
    }

    @Override
    public Article create(String title, String barcode, int price, int quantity, Long categoryId, Long companyId) {
        Category category = categoryService.findById(categoryId);
        Company company = companyService.findById(companyId);
        Article article = new Article(title, barcode, price, quantity, company, category);
        return articleRepository.save(article);
    }

    @Override
    public Article findById(Long id) {
        return this.articleRepository.findById(id).orElseThrow(() -> new ArticleNotFoundException(id));
    }

    public Article update(Long id, String title, String barcode, int price, int quantity, Long companyId, Long categoryId) {
        Category category = categoryService.findById(categoryId);
        Company company = companyService.findById(companyId);
        Article article = this.findById(id);
        article.setTitle(title);
        article.setBarcode(barcode);
        article.setPrice(price);
        article.setQuantity(quantity);
        article.setCompany(company);
        article.setCategory(category);
        return articleRepository.save(article);
    }

    @Override
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }
}
