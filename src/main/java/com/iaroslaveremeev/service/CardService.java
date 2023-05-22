package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.Card;

import java.util.Date;
import java.util.List;

public interface CardService {
    void addCard(Card card);
    List<Card> get();
    Card get(long id);
    Card delete(long id);
    Card update(Card card);
    List<Card> getCardsByCreationDate(Date date);
}
