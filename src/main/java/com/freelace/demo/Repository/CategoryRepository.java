package com.freelace.demo.Repository;

import java.util.List;
import java.util.Optional;

import com.freelace.demo.Model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    void deleteById(Long id);
    void deleteAll();
}
