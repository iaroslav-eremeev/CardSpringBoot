package com.iaroslaveremeev.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "moderators", uniqueConstraints = {@UniqueConstraint(columnNames = {"login", "email"})})
@NoArgsConstructor
@RequiredArgsConstructor
public class Moderator extends User {
    public Moderator(@NonNull String login, @NonNull char[] password, @NonNull String name, @NonNull String email) {
        super(login, password, name, email);
    }
}
