package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.*;
import com.iaroslaveremeev.model.Answer;

import java.util.Date;
import java.util.List;

public interface AnswerService {
    void addAnswer(Answer answer);
    List<Answer> get();
    Answer get(long answerId);
    Answer delete(long answerId);
    void updateAnswerText(String answerText);
    List<Answer> getAnswersByPublicationDate(Date date);
    List<Answer> getAnswersByCardId(long categoryId);
    List<Answer> getAnswersByUserId(long userId);
    void makeVerified(long answerId);
    void makeUnverified(long answerId);
    void incrementRating(long answerId);
    void decrementRating(long answerId);
}
