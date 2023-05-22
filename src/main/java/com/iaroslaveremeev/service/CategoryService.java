package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);
    List<Category> get();
    Category get(long categoryId);
    Category delete(long categoryId);
    List<Category> getCategoriesByName(String name);
    List<Category> getCategoriesByUserId(long userId);
    void updateCategoryName(String name);
}
