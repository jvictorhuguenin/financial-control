package com.finantialcontrol.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Income")
@Entity
public class Income extends BaseModel {
  private String title;

  @Digits(integer = 10, fraction = 2)
  private BigDecimal value;

  @ManyToOne(fetch = FetchType.LAZY)
  private User userID;

  @ManyToOne(fetch = FetchType.LAZY)
  private BankAccount bankAccountId;
}
