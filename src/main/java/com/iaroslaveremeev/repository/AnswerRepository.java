package com.iaroslaveremeev.repository;

import com.iaroslaveremeev.model.Answer;
import com.iaroslaveremeev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> getAnswersByPublicationDate(Date date);
    List<Answer> getAnswersByUserId(long userId);
    List<Answer> getAnswersByCardId(long cardId);
}
