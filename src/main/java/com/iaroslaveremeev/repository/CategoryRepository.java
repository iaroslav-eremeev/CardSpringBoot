package com.iaroslaveremeev.repository;

import com.iaroslaveremeev.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> getCategoriesByName(String name);
    List<Category> getCategoriesByUserId(long userId);
    @Modifying
    @Query("update Category category set category.name=:name")
    void updateCategoryName(String name);
}
