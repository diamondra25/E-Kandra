package com.example.ikandra.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ikandra.Model.Category;
import com.example.ikandra.Repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepo;

    public List<Category> getAll(){
        return categoryRepo.findAll();
    }

    public Category getById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    public Category create(Category category){
        return categoryRepo.save(category);
    }
    
    public Category update(Category category){
        Category existCategory= categoryRepo.findById(category.getId()).orElse(null);
        if(existCategory!=null){
            return categoryRepo.save(existCategory);
        }
        return null;
    }

    public void deleteById(Long id){
       categoryRepo.deleteById(id);
    }

    public void deleteAll(){
        categoryRepo.deleteAll();
    }
}
