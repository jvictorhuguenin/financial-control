package com.finantialcontrol.model;

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
@Table(name = "expense-limit")
@Entity
public class ExpenseLimit extends BaseModel {
  private Integer limit;
  private Date limitDate;
  @ManyToOne
  private User userID;
  @ManyToOne
  private BankAccount bankAccountID;
}
