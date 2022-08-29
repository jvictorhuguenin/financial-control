package com.finantialcontrol.infrastructure.data.db.jpa.repositories;

import com.finantialcontrol.infrastructure.data.db.jpa.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
