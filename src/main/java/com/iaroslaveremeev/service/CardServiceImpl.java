package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.Card;
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
     * Retrieves a list of cards by date of creation.
     *
     * @param date The card creation date.
     * @return A list of cards with the specified creation date.
     */
    @Override
    public List<Card> getCardsByCreationDate(Date date) {
        return this.cardRepository.getCardsByCreationDate(date);
    }

    /**
     * Retrieves a list of cards by category ID.
     *
     * @param categoryId The ID of the card category.
     * @return A list of cards with the specified category ID.
     */
    @Override
    public List<Card> getCardsByCategoryId(long categoryId) {
        return this.cardRepository.getCardsByCategoryId(categoryId);
    }
}
