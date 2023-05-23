package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.Role;
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
     * Setter methods called by the Spring framework
     * to inject all the Repository instances.
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
    /**
     * Retrieves a list of users by their role from the repository.
     *
     * @param role The role of the users.
     * @return A list of users with the specified role.
     */
    @Override
    public List<User> getUsersByRole(Role role) {
        return this.userRepository.getUsersByRole(role);
    }

    /**
     * Retrieves a user by their email from the repository.
     *
     * @param email The email of the user.
     * @return The user with the specified email.
     */
    @Override
    public User getUserByEmail(String email) {
        return this.userRepository.getUserByEmail(email);
    }

    /**
     * Retrieves a user by their login from the repository.
     *
     * @param login The login of the user.
     * @return The user with the specified login.
     */
    @Override
    public User getUserByLogin(String login) {
        return this.userRepository.getUserByLogin(login);
    }

    /**
     * Retrieves a user by their hash code
     *
     * @param hash The user hash code.
     * @return The user with the specified hash code.
     */
    @Override
    public User getUserByHash(String hash) {
        return this.userRepository.getUserByHash(hash);
    }

    /**
     * Updates the login of the current user.
     *
     * @param newLogin The new login value.
     */
    @Override
    public void updateUserLogin(String newLogin) {
        this.userRepository.updateUserLogin(newLogin);
    }

    /**
     * Updates the email of the current user.
     *
     * @param newEmail The new email value.
     */
    @Override
    public void updateUserEmail(String newEmail) {
        this.userRepository.updateUserEmail(newEmail);
    }

    /**
     * Updates the first name of the current user.
     *
     * @param newName The new name value.
     */
    @Override
    public void updateUserName(String newName) {
        this.userRepository.updateUserName(newName);
    }

    /**
     * Updates the role (SIMPLE, MODERATOR or ADMIN) of the current user.
     *
     * @param newRole The new Role value.
     */
    @Override
    public void updateUserRole(Role newRole) {
        this.userRepository.updateUserRole(newRole);
    }
}
