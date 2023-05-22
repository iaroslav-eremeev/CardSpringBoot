package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.Card;
import com.iaroslaveremeev.model.Category;
import com.iaroslaveremeev.model.User;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);
    List<Category> get();
    Category get(long categoryId);
    List<Card> getCardList(long categoryId);
    User getUser(long categoryId);
    Category delete(long categoryId);
    List<Category> getCategoriesByName(String name);
    List<Category> getCategoriesByUserId(long userId);
    void updateCategoryName(String name);
}
