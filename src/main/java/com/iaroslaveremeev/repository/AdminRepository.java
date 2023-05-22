package com.iaroslaveremeev.repository;

import com.iaroslaveremeev.model.Admin;
import com.iaroslaveremeev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
