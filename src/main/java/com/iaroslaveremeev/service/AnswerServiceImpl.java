package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.Answer;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Override
    public void addAnswer(Answer answer) {

    }

    @Override
    public List<Answer> get() {
        return null;
    }

    @Override
    public Answer get(long answerId) {
        return null;
    }

    @Override
    public Answer delete(long answerId) {
        return null;
    }

    @Override
    public void updateAnswerText(String answerText) {

    }

    @Override
    public List<Answer> getAnswersByPublicationDate(Date date) {
        return null;
    }

    @Override
    public List<Answer> getAnswersByCardId(long categoryId) {
        return null;
    }

    @Override
    public List<Answer> getAnswersByUserId(long userId) {
        return null;
    }

    @Override
    public void makeVerified(long answerId) {

    }

    @Override
    public void makeUnverified(long answerId) {

    }

    @Override
    public void incrementRating(long answerId) {

    }

    @Override
    public void decrementRating(long answerId) {

    }
}
