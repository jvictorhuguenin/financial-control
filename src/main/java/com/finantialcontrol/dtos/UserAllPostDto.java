package com.finantialcontrol.dtos;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAllPostDto implements Serializable {
  private Integer id;
  private String firstName;
  private String lastName;
  private String username;
  private String email;
  private String password;

  // Relations
  private List<BankAccountDto> bankAccountIds;
  private List<IncomeDto> incomeIds;
  private List<ExpenseDto> expenseIds;
  private List<ExpenseLimitDto> expenseLimitIds;
  private List<CardDto> cardIds;
}
