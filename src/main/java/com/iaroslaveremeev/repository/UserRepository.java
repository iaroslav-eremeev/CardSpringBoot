package com.iaroslaveremeev.repository;

import com.iaroslaveremeev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getUsersByRegDate(Date date);
    List<User> getUsersByName(String name);
}
