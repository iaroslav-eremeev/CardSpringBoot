package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);
    List<Category> get();
    Category get(long id);
    Category delete(long id);
    Category update(Category category);
    List<Category> getCategoriesByName(String name);
}
