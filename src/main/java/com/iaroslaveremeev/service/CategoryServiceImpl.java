package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.Category;
import com.iaroslaveremeev.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
     * @param id The category ID.
     * @return The category with the specified ID.
     * @throws IllegalArgumentException
     * If the category with the specified ID does not exist.
     */
    @Override
    public Category get(long id) {
        return this.categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category with this id does not exist"));
    }

    /**
     * Deletes a category by its ID from the repository.
     *
     * @param id The ID of the category to be deleted.
     * @return The deleted category.
     * @throws IllegalArgumentException
     * If the category with the specified ID does not exist.
     */
    @Override
    public Category delete(long id) {
        Category category = this.get(id);
        this.categoryRepository.deleteById(id);
        return category;
    }

    /**
     * Updates the details of a category in the repository.
     *
     * @param category The updated category.
     * @return The updated category.
     * @throws IllegalArgumentException
     * If one or more parameters are invalid or
     * if a category with the same parameters already exists.
     */
    @Override
    public Category update(Category category) {
        if (category.getName().length() == 0)  {
            throw new IllegalArgumentException("Parameters are invalid");
        }
        Category baseCategory = this.get(category.getId());
        baseCategory.setName(category.getName());
        try {
            this.categoryRepository.save(baseCategory);
            return baseCategory;
        } catch (Exception e) {
            throw new IllegalArgumentException("Category with such parameters already exists!");
        }
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
}
