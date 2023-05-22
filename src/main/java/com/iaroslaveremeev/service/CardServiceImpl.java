package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.Answer;
import com.iaroslaveremeev.model.Card;
import com.iaroslaveremeev.model.Category;
import com.iaroslaveremeev.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    private CardRepository cardRepository;

    /**
     * Setter method called by the Spring framework
     * to inject the CardRepository instance.
     */
    @Autowired
    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    /**
     * Adds a new card to the repository.
     *
     * @param card The card to be added.
     * @throws IllegalArgumentException If the card is already added.
     */
    @Override
    public void addCard(Card card) {
        try {
            this.cardRepository.save(card);
        } catch (Exception e) {
            throw new IllegalArgumentException("Card is already added!");
        }
    }

    /**
     * Retrieves all cards from the repository.
     *
     * @return A list of all cards.
     */
    @Override
    public List<Card> get() {
        return this.cardRepository.findAll();
    }

    /**
     * Retrieves a card by their ID from the repository.
     *
     * @param id The card ID.
     * @return The card with the specified ID.
     * @throws IllegalArgumentException
     * If the card with the specified ID does not exist.
     */
    @Override
    public Card get(long id) {
        return this.cardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Card with this id does not exist"));
    }

    /**
     * Retrieves the list of answers associated with a card.
     *
     * @param cardId The ID of the card.
     * @return The list of answers associated with the card.
     */
    @Override
    public List<Answer> getCardAnswers(long cardId) {
        Card card = this.cardRepository.getById(cardId);
        return card.getCardAnswers();
    }

    /**
     * Retrieves the card category.
     *
     * @param cardId The ID of the card.
     * @return The category associated with the card.
     */
    @Override
    public Category getCategory(long cardId) {
        Card card = this.cardRepository.getById(cardId);
        return card.getCategory();
    }

    /**
     * Deletes a card by its ID from the repository.
     *
     * @param id The ID of the card to be deleted.
     * @return The deleted card.
     * @throws IllegalArgumentException
     * If the card with the specified ID does not exist.
     */
    @Override
    public Card delete(long id) {
        Card card = this.get(id);
        this.cardRepository.deleteById(id);
        return card;
    }

    /**
     * Updates the question of a card.
     *
     * @param question The new question for the card.
     */
    @Override
    public void updateQuestion(String question) {
        this.cardRepository.updateQuestion(question);
    }

    /**
     * Retrieves a list of cards by first name from the repository.
     *
     * @param date The first name of the card.
     * @return A list of cards with the specified first name.
     */
    @Override
    public List<Card> getCardsByCreationDate(Date date) {
        return this.cardRepository.getCardsByCreationDate(date);
    }
}
