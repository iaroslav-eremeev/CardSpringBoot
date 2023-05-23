package com.iaroslaveremeev.service;

import com.iaroslaveremeev.model.Answer;
import com.iaroslaveremeev.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private AnswerRepository answerRepository;

    /**
     * Setter method called by the Spring framework
     * to inject the AnswerRepository instance.
     */
    @Autowired
    public void setAnswerRepository(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    /**
     * Adds a new answer to the repository.
     *
     * @param answer The answer to be added.
     * @throws IllegalArgumentException If the answer is already added.
     */
    @Override
    public void addAnswer(Answer answer) {
        try {
            this.answerRepository.save(answer);
        } catch (Exception e) {
            throw new IllegalArgumentException("Asnwer is already added!");
        }
    }

    /**
     * Retrieves all answers from the repository.
     *
     * @return A list of all answers.
     */
    @Override
    public List<Answer> get() {
        return this.answerRepository.findAll();
    }

    /**
     * Retrieves an answer by its ID from the repository.
     *
     * @param answerId The ID of the answer.
     * @return The answer with the specified ID, or null if not found.
     */
    @Override
    public Answer get(long answerId) {
        return this.answerRepository.findById(answerId)
                .orElse(null);
    }

    /**
     * Deletes an answer by its ID from the repository.
     *
     * @param answerId The ID of the answer to delete.
     * @return The deleted answer, or null if not found.
     */
    @Override
    public Answer delete(long answerId) {
        Answer answer = this.get(answerId);
        if (answer != null) {
            this.answerRepository.deleteById(answerId);
        }
        return answer;
    }

    /**
     * Updates the text of the answer.
     *
     * @param answerText The new text for the answer.
     */
    @Override
    public void updateAnswerText(String answerText) {
        this.answerRepository.updateAnswerText(answerText);
    }

    /**
     * Retrieves answers by their publication date from the repository.
     *
     * @param date The publication date of the answers.
     * @return A list of answers with the specified publication date.
     */
    @Override
    public List<Answer> getAnswersByPublicationDate(Date date) {
        return this.answerRepository.getAnswersByPublicationDate(date);
    }

    /**
     * Retrieves answers by the ID of the card they belong to.
     *
     * @param cardId The ID of the card.
     * @return A list of answers belonging to the specified card.
     */
    @Override
    public List<Answer> getAnswersByCardId(long cardId) {
        return this.answerRepository.getAnswersByCardId(cardId);
    }

    /**
     * Retrieves answers by the ID of the user who provided them.
     *
     * @param userId The ID of the user.
     * @return A list of answers provided by the specified user.
     */
    @Override
    public List<Answer> getAnswersByUserId(long userId) {
        return this.answerRepository.getAnswersByUserId(userId);
    }

    /**
     * Marks an answer as verified.
     *
     * @param answerId The ID of the answer to mark as verified.
     */
    @Override
    public void makeVerified(long answerId) {
        Answer answer = this.get(answerId);
        if (answer != null) {
            answer.setVerified(true);
            this.answerRepository.save(answer);
        }
    }

    /**
     * Marks an answer as unverified.
     *
     * @param answerId The ID of the answer to mark as unverified.
     */
    @Override
    public void makeUnverified(long answerId) {
        Answer answer = this.get(answerId);
        if (answer != null) {
            answer.setVerified(false);
            this.answerRepository.save(answer);
        }
    }

    /**
     * Increments the rating of an answer by 1.
     *
     * @param answerId The ID of the answer to increment the rating.
     */
    @Override
    public void incrementRating(long answerId) {
        Answer answer = this.get(answerId);
        if (answer != null) {
            int rating = answer.getRating();
            answer.setRating(rating + 1);
            this.answerRepository.save(answer);
        }
    }

    /**
     * Decrements the rating of an answer by 1.
     *
     * @param answerId The ID of the answer to decrement the rating.
     */
    @Override
    public void decrementRating(long answerId) {
        Answer answer = this.get(answerId);
        if (answer != null) {
            int rating = answer.getRating();
            answer.setRating(rating - 1);
            this.answerRepository.save(answer);
        }
    }
}
