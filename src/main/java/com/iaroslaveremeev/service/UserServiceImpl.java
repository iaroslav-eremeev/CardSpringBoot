package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.User;
import com.iaroslaveremeev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    /**
     * Setter method called by the Spring framework
     * to inject the UserRepository instance.
     */
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /**
     * Adds a new user to the repository.
     *
     * @param user The user to be added.
     * @throws IllegalArgumentException If the user is already added.
     */
    @Override
    public void addUser(User user) {
        try {
            this.userRepository.save(user);
        } catch (Exception e) {
            throw new IllegalArgumentException("User is already added!");
        }
    }

    /**
     * Retrieves all users from the repository.
     *
     * @return A list of all users.
     */
    @Override
    public List<User> get() {
        return this.userRepository.findAll();
    }

    /**
     * Retrieves a user by their ID from the repository.
     *
     * @param id The user ID.
     * @return The user with the specified ID.
     * @throws IllegalArgumentException
     * If the user with the specified ID does not exist.
     */
    @Override
    public User get(long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with this id does not exist"));
    }

    /**
     * Deletes a user by its ID from the repository.
     *
     * @param id The ID of the user to be deleted.
     * @return The deleted user.
     * @throws IllegalArgumentException
     * If the user with the specified ID does not exist.
     */
    @Override
    public User delete(long id) {
        User user = this.get(id);
        this.userRepository.deleteById(id);
        return user;
    }

    /**
     * Updates the details of a user in the repository.
     *
     * @param user The updated user.
     * @return The updated user.
     * @throws IllegalArgumentException
     * If one or more parameters are invalid or
     * if a user with the same parameters already exists.
     */
    @Override
    public User update(User user) {
        if (user.getName().length() == 0 || user.getLogin().length() == 0 ||
                user.getPassword().length == 0) {
            throw new IllegalArgumentException("One or more parameters are invalid");
        }
        User baseUser = this.get(user.getId());
        baseUser.setName(user.getName());
        baseUser.setLogin(user.getLogin());
        baseUser.setPassword(user.getPassword());
        baseUser.setRegDate(user.getRegDate());
        try {
            this.userRepository.save(baseUser);
            return baseUser;
        } catch (Exception e) {
            throw new IllegalArgumentException("User with such parameters already exists!");
        }
    }

    /**
     * Retrieves a list of users by first name from the repository.
     *
     * @param name The first name of the user.
     * @return A list of users with the specified first name.
     */
    @Override
    public List<User> getUsersByName(String name) {
        return this.userRepository.getUsersByName(name);
    }

    /**
     * Retrieves a list of users by date of their registration from the repository.
     *
     * @param regDate The date of user registration.
     * @return A list of users with the specified registration date.
     */
    @Override
    public List<User> getUsersByRegDate(Date regDate) {
        return this.userRepository.getUsersByRegDate(regDate);
    }
}
