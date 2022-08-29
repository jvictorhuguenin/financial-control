package com.finantialcontrol.data.db.jpa.repositories.interfaces;

import com.finantialcontrol.data.db.jpa.entities.ExpenseLimit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseLimitRepository extends JpaRepository<ExpenseLimit, Long> {
}
