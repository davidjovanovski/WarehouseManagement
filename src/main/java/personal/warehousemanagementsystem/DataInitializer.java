package personal.warehousemanagementsystem;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import personal.warehousemanagementsystem.models.Category;
import personal.warehousemanagementsystem.models.Company;
import personal.warehousemanagementsystem.models.enums.Role;
import personal.warehousemanagementsystem.repository.UserRepository;
import personal.warehousemanagementsystem.service.ArticleService;
import personal.warehousemanagementsystem.service.CategoryService;
import personal.warehousemanagementsystem.service.CompanyService;
import personal.warehousemanagementsystem.service.UserService;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final UserService userService;
    private final ArticleService articleService;
    private final CategoryService categoryService;
    private final CompanyService companyService;
    private final UserRepository userRepository;


    @PostConstruct
    public void populate_db(){
        if(userRepository.findByUsername("Dasho").isPresent()) return;

        userService.register("Dasho", "dasho", "dasho", "Dashovski", Role.ADMIN);

        Category Ovosje = categoryService.create("Ovosje");
        Category Zelencuk = categoryService.create("Zelencuk");

        Company Domigo = companyService.create("Domigo", "Skopje");
        Company Gadzo = companyService.create("Gadzo", "VUCIDOL");

        articleService.create("Jabolko", "1", 10, 5, Domigo.getId(), Ovosje.getId());
        articleService.create("Krastavica", "2", 20, 50, Gadzo.getId(), Zelencuk.getId());
    }
}
