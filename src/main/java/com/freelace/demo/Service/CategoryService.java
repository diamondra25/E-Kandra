package com.freelace.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelace.demo.Repository.CategoryRepository;
import com.freelace.demo.Model.Category;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public Category update (Long id, Category categoryDetails) {
        Category category = getById(id);
        if (category != null) {
            category.setName(categoryDetails.getName());
            return categoryRepository.save(category);
        }
        return null;
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public void deleteAll() {
        categoryRepository.deleteAll();
    }
}
