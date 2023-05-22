package com.iaroslaveremeev.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;
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
    private long id;
    @NonNull
    private String question; // Question made by User
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Answer> cardAnswers = new ArrayList<>(); // Answers to the question
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
