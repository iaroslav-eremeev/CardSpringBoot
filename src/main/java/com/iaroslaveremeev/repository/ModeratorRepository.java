package com.iaroslaveremeev.repository;

import com.iaroslaveremeev.model.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeratorRepository extends JpaRepository<Moderator, Long> {
}
