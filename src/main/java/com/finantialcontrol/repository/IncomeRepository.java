package com.finantialcontrol.repository;

import com.finantialcontrol.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
