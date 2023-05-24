package com.iaroslaveremeev.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "answers")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @NonNull
    private String answerText; // Answer text
    private int rating = 0; // Answer rating
    private boolean verified = false; // Marked as verified by a Moderator or an Admin
    @ManyToOne
    @JsonIgnore
    @NonNull
    @JoinColumn(name = "card_id", nullable = false)
    private Card card; // Card to that the Answer belongs
    @ManyToOne
    @JsonIgnore
    @NonNull
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // User who gave the answer

    // Date of Answer publication, corresponds to the moment
    // when the answer is provided
    @NonNull
    private Date publicationDate = new Date();
}
