package com.iaroslaveremeev.repository;

import com.iaroslaveremeev.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> getCategoriesByName(String name);
}
