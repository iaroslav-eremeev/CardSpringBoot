package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> get();
    User get(long id);
    User delete(long id);
    User update(User user);
    List<User> getUsersByName(String name);
    List<User> getUsersByRegDate(Date regDate);
}
