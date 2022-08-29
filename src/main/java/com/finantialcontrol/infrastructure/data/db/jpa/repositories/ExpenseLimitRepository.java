package com.finantialcontrol.infrastructure.data.db.jpa.repositories;

import com.finantialcontrol.infrastructure.data.db.jpa.entities.ExpenseLimit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseLimitRepository extends JpaRepository<ExpenseLimit, Long> {
}
