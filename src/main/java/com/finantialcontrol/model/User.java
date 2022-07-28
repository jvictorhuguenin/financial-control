package com.finantialcontrol.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User extends BaseModel {
  private String name;
  private String lastName;
  private String email;
  private String hash;
  private Boolean enabled;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<BankAccount> bankAccountIds;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Income> incomeIds;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Expense> expenseIds;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<ExpenseLimit> expenseLimitIds;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Card> cardIds;
}