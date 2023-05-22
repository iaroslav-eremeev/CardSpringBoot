package com.iaroslaveremeev.repository;

import com.iaroslaveremeev.model.Moderator;
import com.iaroslaveremeev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeratorRepository extends JpaRepository<Moderator, Long> {
}
