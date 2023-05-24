package com.iaroslaveremeev.repository;

import com.iaroslaveremeev.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> getAnswersByPublicationDate(Date date);
    List<Answer> getAnswersByUserId(long userId);
    List<Answer> getAnswersByCardId(long cardId);
    @Modifying
    @Query("update Answer answer set answer.answerText=:answerText")
    void updateAnswerText(String answerText);
}
