package personal.warehousemanagementsystem.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.warehousemanagementsystem.models.Company;
import personal.warehousemanagementsystem.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> listCompanies(){
        return companyService.listCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable Long id){
        return companyService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Company> create(@RequestParam String name,
                                          @RequestParam String city){
        Company company = companyService.create(name, city);
        return ResponseEntity.status(HttpStatus.CREATED).body(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> update(@PathVariable Long id,
                                          @RequestParam String name,
                                          @RequestParam String city){
        Company company = companyService.update(id, name, city);
        return ResponseEntity.ok(company);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        companyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
