package com.iaroslaveremeev.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "admins", uniqueConstraints = {@UniqueConstraint(columnNames = {"login"})})
@NoArgsConstructor
@RequiredArgsConstructor
public class Admin extends User {
    public Admin(@NonNull String login, @NonNull char[] password, @NonNull String name, @NonNull String email) {
        super(login, password, name, email);
    }
}
