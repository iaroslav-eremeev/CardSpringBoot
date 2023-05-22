package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.Role;
import com.iaroslaveremeev.model.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> get();
    User get(long id);
    User delete(long id);
    List<User> getUsersByName(String name);
    List<User> getUsersByRegDate(Date regDate);
    List<User> getUsersByRole(Role role);
    User getUserByEmail(String email);
    User getUserByLogin(String login);
    void updateUserLogin(String newLogin);
    void updateUserEmail(String newEmail);
    void updateUserName(String newName);
    void updateUserRole(Role role);
}
