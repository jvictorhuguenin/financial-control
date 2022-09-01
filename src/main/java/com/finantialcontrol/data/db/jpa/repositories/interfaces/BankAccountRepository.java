package com.finantialcontrol.data.db.jpa.repositories.interfaces;

import com.finantialcontrol.data.db.jpa.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
