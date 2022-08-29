package com.finantialcontrol.infrastructure.data.db.jpa.repositories;

import com.finantialcontrol.infrastructure.data.db.jpa.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
