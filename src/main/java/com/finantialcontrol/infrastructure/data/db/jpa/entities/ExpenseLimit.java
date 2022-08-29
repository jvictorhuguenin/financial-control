package com.finantialcontrol.infrastructure.data.db.jpa.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "expense_limits")
@Entity
public class ExpenseLimit extends BaseModel {
  private Integer limitAmount;
  private Date limitDate;
  @ManyToOne
  private User userID;
  @ManyToOne
  private BankAccount bankAccountID;
}
