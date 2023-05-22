package com.iaroslaveremeev.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Card is the entity that combines the question, made by user,
 * the answer, provided by whoever is responsible for giving answers (admin or bot)
 */
@Entity
@Table(name = "cards")
@Data
@NoArgsConstructor
@RequiredArgsConstructor

public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NonNull
    private String question; // Question made by User
    @NonNull
    private String answer; // Answer to the question
    @ManyToOne
    @JsonIgnore
    @NonNull
    @JoinColumn(name = "category_id", nullable = false)
    private Category category; // Question Category for better navigation through questions

    // Date of Card creation, corresponds to the moment
    // when the answer is provided and a Card object is created
    @NonNull
    private Date creationDate = new Date();
}
