package com.finantialcontrol.infrastructure.data.db.jpa.repositories;

import com.finantialcontrol.infrastructure.data.db.jpa.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
