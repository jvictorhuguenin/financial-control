package com.finantialcontrol.model;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
@Entity
public class User extends BaseModel {
  private String firstName;
  private String lastName;
  private String username;
  private String email;
  private String hash;
  private Boolean enabled = true;
  @ElementCollection
  @Column(name = "authority")
  private Set<String> roles;
  @OneToMany(mappedBy = "userID", cascade = CascadeType.ALL)
  private List<BankAccount> bankAccountIds;
  @OneToMany(mappedBy = "userID", cascade = CascadeType.ALL)
  private List<Income> incomeIds;
  @OneToMany(mappedBy = "userID", cascade = CascadeType.ALL)
  private List<Expense> expenseIds;
  @OneToMany(mappedBy = "userID", cascade = CascadeType.ALL)
  private List<ExpenseLimit> expenseLimitIds;
  @OneToMany(mappedBy = "userID", cascade = CascadeType.ALL)
  private List<Card> cardIds;
}