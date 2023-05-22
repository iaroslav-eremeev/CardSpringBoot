package com.iaroslaveremeev.repository;

import com.iaroslaveremeev.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> getCardsByCreationDate(Date date);
}
