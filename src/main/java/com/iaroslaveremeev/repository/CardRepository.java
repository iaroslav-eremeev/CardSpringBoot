package com.iaroslaveremeev.repository;

import com.iaroslaveremeev.model.Answer;
import com.iaroslaveremeev.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> getCardsByCreationDate(Date date);
    List<Card> getCardsByCategoryId(long categoryId);
    @Modifying
    @Query("update Card card set card.question=:question")
    void updateQuestion(String question);
}
