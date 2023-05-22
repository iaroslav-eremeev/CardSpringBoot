package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.Card;

import java.util.Date;
import java.util.List;

public interface CardService {
    void addCard(Card card);
    List<Card> get();
    Card get(long cardId);
    Card delete(long cardId);
    void updateQuestion(String question);
    List<Card> getCardsByCreationDate(Date date);
    List<Card> getCardsByCategoryId(long categoryId);
}
