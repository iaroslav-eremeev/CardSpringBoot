package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.Category;
import com.iaroslaveremeev.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    /**
     * Setter method called by the Spring framework
     * to inject the CategoryRepository instance.
     */
    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Adds a new category to the repository.
     *
     * @param category The category to be added.
     * @throws IllegalArgumentException If the category is already added.
     */
    @Override
    public void addCategory(Category category) {
        try {
            this.categoryRepository.save(category);
        } catch (Exception e) {
            throw new IllegalArgumentException("Category is already added!");
        }
    }

    /**
     * Retrieves all categories from the repository.
     *
     * @return A list of all categories.
     */
    @Override
    public List<Category> get() {
        return this.categoryRepository.findAll();
    }

    /**
     * Retrieves a category by their ID from the repository.
     *
     * @param categoryId The category ID.
     * @return The category with the specified ID.
     * @throws IllegalArgumentException
     * If the category with the specified ID does not exist.
     */
    @Override
    public Category get(long categoryId) {
        return this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category with this id does not exist"));
    }

    /**
     * Deletes a category by its ID from the repository.
     *
     * @param categoryId The ID of the category to be deleted.
     * @return The deleted category.
     * @throws IllegalArgumentException
     * If the category with the specified ID does not exist.
     */
    @Override
    public Category delete(long categoryId) {
        Category category = this.get(categoryId);
        this.categoryRepository.deleteById(categoryId);
        return category;
    }

    /**
     * Retrieves a list of categories by first name from the repository.
     *
     * @param name The first name of the category.
     * @return A list of categories with the specified first name.
     */
    @Override
    public List<Category> getCategoriesByName(String name) {
        return this.categoryRepository.getCategoriesByName(name);
    }

    /**
     * Retrieves a list of categories associated with a specific user.
     *
     * @param userId The ID of the user.
     * @return A list of categories associated with the specific user.
     */
    @Override
    public List<Category> getCategoriesByUserId(long userId) {
        return this.categoryRepository.getCategoriesByUserId(userId);
    }

    /**
     * Updates the name of the current category.
     *
     * @param newCatName The new category name.
     */
    @Override
    public void updateCategoryName(String newCatName) {
        this.categoryRepository.updateCategoryName(newCatName);
    }

}
