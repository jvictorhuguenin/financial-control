package com.finantialcontrol.repository;

import com.finantialcontrol.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
