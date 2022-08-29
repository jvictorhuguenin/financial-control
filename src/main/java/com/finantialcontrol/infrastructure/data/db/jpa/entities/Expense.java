package com.finantialcontrol.infrastructure.data.db.jpa.entities;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
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
@Entity
@Table(name = "expenses")
public class Expense extends BaseModel {
  private String title;
  @Digits(integer = 10, fraction = 2)
  private BigDecimal value;
  @ManyToOne(fetch = FetchType.LAZY)
  private Card card;
  @ManyToOne(fetch = FetchType.LAZY)
  private Card bankAccountID;
  @ManyToOne(fetch = FetchType.LAZY)
  private Card userID;

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
