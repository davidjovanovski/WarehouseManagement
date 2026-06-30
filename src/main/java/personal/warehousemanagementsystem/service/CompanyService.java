package personal.warehousemanagementsystem.service;

import personal.warehousemanagementsystem.models.Company;

import java.util.List;

public interface CompanyService {
    List<Company> listCompanies();

    Company findById(Long id);

    Company create(String name, String city);

    Company update(Long id, String name, String city);

    void delete(Long id);
}
