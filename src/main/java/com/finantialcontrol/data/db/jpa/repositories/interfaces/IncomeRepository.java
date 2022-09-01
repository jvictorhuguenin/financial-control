package com.finantialcontrol.data.db.jpa.repositories.interfaces;

import com.finantialcontrol.data.db.jpa.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
