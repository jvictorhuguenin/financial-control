package com.finantialcontrol.dtos;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import javax.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto{
  private Integer id;
  private Timestamp createdAt;
  private Timestamp updatedAt;
  @NonNull
  private String name;
  @NonNull
  private Date closingDate;
  @NonNull
  @Digits(integer = 10, fraction = 2)
  private BigDecimal cardLimit;
}
