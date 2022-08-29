package com.finantialcontrol.infrastructure.data.db.jpa.entities;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "bank_accounts")
@Entity
public class BankAccount extends BaseModel {
  private String bankName;
  @Digits(integer = 10, fraction = 2)
  private BigDecimal balance;

  // Relations
  @OneToMany(mappedBy = "bankAccountID", cascade = CascadeType.ALL)
  private List<ExpenseLimit> expenseLimitIDs;
  @OneToMany(mappedBy = "bankAccountID", cascade = CascadeType.ALL)
  private List<Expense> expenseIds;
  @OneToMany(mappedBy = "bankAccountID", cascade = CascadeType.ALL)
  private List<Income> incomeIds;
  @ManyToOne
  private User userID;
}
