package com.example.ikandra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ikandra.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
