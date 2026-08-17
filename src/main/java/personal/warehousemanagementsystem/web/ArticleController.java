package personal.warehousemanagementsystem.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.warehousemanagementsystem.models.Article;
import personal.warehousemanagementsystem.service.ArticleService;

import java.util.List;


@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @GetMapping
    public List<Article> listArticles(){
        return articleService.listArticles();
    }

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable Long id){
        return articleService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Article> create(@RequestParam String title,
                                          @RequestParam String barcode,
                                          @RequestParam int price,
                                          @RequestParam int quantity,
                                          @RequestParam Long companyId,
                                          @RequestParam Long categoryId){
        Article article = articleService.create(title, barcode, price, quantity, companyId, categoryId);
        return ResponseEntity.status(HttpStatus.CREATED).body(article);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id,
                                          @RequestParam String title,
                                          @RequestParam String barcode,
                                          @RequestParam int price,
                                          @RequestParam int quantity,
                                          @RequestParam Long companyId,
                                          @RequestParam Long categoryId){

        Article article = articleService.update(id, title, barcode, price, quantity, companyId, categoryId);
        return ResponseEntity.ok(article);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        articleService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
