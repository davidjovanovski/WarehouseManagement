package personal.warehousemanagementsystem.service.impl;

import org.springframework.stereotype.Service;
import personal.warehousemanagementsystem.models.Company;
import personal.warehousemanagementsystem.models.exceptions.CompanyNotFoundException;
import personal.warehousemanagementsystem.repository.CompanyRepository;
import personal.warehousemanagementsystem.service.CompanyService;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @Override
    public Company create(String name, String city) {
        Company company = new Company(name, city);
        return companyRepository.save(company);
    }

    @Override
    public List<Company> listCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException(id));
    }

    @Override
    public Company update(Long id, String name, String city) {
        Company company = this.findById(id);
        company.setName(name);
        company.setCity(city);
        return companyRepository.save(company);
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }
}
