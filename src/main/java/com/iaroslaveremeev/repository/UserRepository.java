package com.iaroslaveremeev.repository;

import com.iaroslaveremeev.model.Role;
import com.iaroslaveremeev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getUsersByRegDate(Date date);
    List<User> getUsersByName(String name);
    List<User> getUsersByRole(Role role);
    User getUserByEmail(String email);
    User getUserByLogin(String login);
    User getUserByHash(String hash);
}
