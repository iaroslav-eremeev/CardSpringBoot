package com.iaroslaveremeev.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User can ask questions and get answers. User can also give answers to other users
 * User may choose category of a newly-created question
 */
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"login", "email"})})
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @NonNull
    private String login; // User login - must be unique
    @NonNull
    private char[] password; // User password
    @NonNull
    private String name; // User first name
    @NonNull
    private String email; // User email - must be unique
    @NonNull
    private Date regDate = new Date(); // Date of registration - created at the moment of Object instantiation
    @NonNull
    private Role role = Role.SIMPLE;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Category> categoryList = new ArrayList<>(); // List of question categories that user chose for themselves

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Answer> answerList = new ArrayList<>(); // List of answers that User provided

    @ToString.Exclude
    @JsonIgnore
    String hash;
}

