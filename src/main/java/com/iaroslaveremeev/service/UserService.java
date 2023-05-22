package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.Answer;
import com.iaroslaveremeev.model.Card;
import com.iaroslaveremeev.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> get();
    User get(long id);
    User delete(long id);
    List<User> getUsersByName(String name);
    List<User> getUsersByRegDate(Date regDate);
    User getUserByEmail(String email);
    User getUserByLogin(String login);
    void updateUserLogin(String newLogin);
    void updateUserEmail(String newEmail);
    void updateUserName(String newName);
}
