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
    @Modifying
    @Query("update User user set user.login=:login WHERE user.id = :userId")
    void updateUserLogin(@Param("login") String login, @Param("userId") long userId);
    @Modifying
    @Query("update User user set user.email=:email WHERE user.id = :userId")
    void updateUserEmail(@Param("email") String email, @Param("userId") long userId);
    @Modifying
    @Query("update User user set user.name=:name WHERE user.id = :userId")
    void updateUserName(@Param("name") String name, @Param("userId") long userId);
    @Modifying
    @Query("update User user set user.role=:role WHERE user.id = :userId")
    void updateUserRole(@Param("role") Role role, @Param("userId") long userId);
    @Modifying
    @Query("UPDATE User user SET user.hash = :hash WHERE user.id = :userId")
    void updateUserHash(@Param("hash") String hash, @Param("userId") long userId);

}
