package com.finantialcontrol.dtos;

import java.sql.Timestamp;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseLimitDto{
  private Integer id;
  private Timestamp createdAt;
  private Timestamp updatedAt;
  @NonNull
  private Integer limitAmount;
  @NonNull
  private Date limitDate;
}
