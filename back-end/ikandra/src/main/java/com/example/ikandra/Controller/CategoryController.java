package com.example.ikandra.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ikandra.Model.Category;
import com.example.ikandra.Service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<Category> getALl(){
        return categoryService.getAll();
    }

    @GetMapping("{id}")
    public Category getById(@PathVariable Long id){
        return categoryService.getById(id);
    }

    @PostMapping()
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @PutMapping()
    public Category upadate(@RequestBody Category category){
        return categoryService.update(category);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        categoryService.deleteById(id);
    }

    @DeleteMapping()
    public void deleteAll(){
        categoryService.deleteAll();
    }
}
