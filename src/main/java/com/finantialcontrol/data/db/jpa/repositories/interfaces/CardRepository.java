package com.finantialcontrol.data.db.jpa.repositories.interfaces;

import com.finantialcontrol.data.db.jpa.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
