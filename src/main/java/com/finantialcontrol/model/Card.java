package com.finantialcontrol.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "credit_card")
@Entity
public class Card extends BaseModel {
  private String name;
  private Date closingDate;
  @Digits(integer = 10, fraction = 2)
  private BigDecimal limit;
  @ManyToOne(fetch = FetchType.LAZY)
  private User userID;
  @OneToMany(mappedBy = "credit_card", cascade = CascadeType.ALL)
  private List<Expense> expenseIDs;
}
