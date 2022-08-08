package com.finantialcontrol.dtos;

import java.sql.Timestamp;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGetDto {
  private Integer id;
  private Timestamp createdAt;
  private Timestamp updatedAt;
  @NonNull
  private String firstName;
  @NonNull
  private String lastName;
  @NonNull
  private String username;
  @NonNull
  private String email;
  private Boolean enabled;

  //Relations
  private List<BankAccountDto> bankAccountIds;
  private List<IncomeDto> incomeIds;
  private List<ExpenseDto> expenseIds;
  private List<ExpenseLimitDto> expenseLimitIds;
  private List<CardDto> cardIds;
}
