package com.finantialcontrol.dtos;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.validation.constraints.Digits;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class BankAccountDto{
  private Integer id;
  private Timestamp createdAt;
  private Timestamp updatedAt;
  @NonNull
  private String bankName;
  @NonNull
  @Digits(integer = 10, fraction = 2)
  private BigDecimal balance;
}
