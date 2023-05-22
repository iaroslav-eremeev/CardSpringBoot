package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.Answer;
import com.iaroslaveremeev.model.Card;
import com.iaroslaveremeev.model.Category;

import java.util.Date;
import java.util.List;

public interface CardService {
    void addCard(Card card);
    List<Card> get();
    Card get(long cardId);
    List<Answer> getCardAnswers(long cardId);
    Category getCategory(long cardId);
    Card delete(long cardId);
    void updateQuestion(String question);
    List<Card> getCardsByCreationDate(Date date);
}
