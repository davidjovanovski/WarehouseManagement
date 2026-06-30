package personal.warehousemanagementsystem.service;

import personal.warehousemanagementsystem.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();

    Category findById(Long id);

    Category create(String name);

    Category update(Long id, String name);

    void delete(Long id);

}
