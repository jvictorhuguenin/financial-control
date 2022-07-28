package com.finantialcontrol.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Expense")
public class Expense extends BaseModel {
  private String title;
  @Digits(integer = 10, fraction = 2)
  private BigDecimal value;
  @ManyToOne(fetch = FetchType.LAZY)
  private Card cardID;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Expense expense = (Expense) o;
    return getId() != null && Objects.equals(getId(), expense.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
