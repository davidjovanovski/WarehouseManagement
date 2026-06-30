package personal.warehousemanagementsystem.service.impl;

import org.springframework.stereotype.Service;
import personal.warehousemanagementsystem.models.Category;
import personal.warehousemanagementsystem.models.exceptions.CategoryNotFoundException;
import personal.warehousemanagementsystem.repository.CategoryRepository;
import personal.warehousemanagementsystem.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(String name) {
        Category category = new Category(name);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> listCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @Override
    public Category update(Long id, String name) {
        Category category= this.findById(id);
        category.setName(name);
        return this.categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
