package com.iaroslaveremeev.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User can ask questions via the application and get answers.
 * They choose categories of questions and ask questions
 */
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"login"})})
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NonNull
    private String login; // User login - must be unique
    @NonNull
    private char[] password; // User password
    @NonNull
    private String name; // User first name
    @NonNull
    private Date regDate = new Date(); // Date of registration - created at the moment of Object instantiation
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    // If a User is deleted, associated Categories and Cards are also deleted
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE)
    private List<Category> categoryList = new ArrayList<>(); // List of question categories that user chose to play

}

