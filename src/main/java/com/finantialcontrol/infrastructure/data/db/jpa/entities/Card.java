package com.finantialcontrol.infrastructure.data.db.jpa.entities;

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
@Table(name = "cards")
@Entity
public class Card extends BaseModel {
  private String name;
  private Date closingDate;
  @Digits(integer = 10, fraction = 2)
  private BigDecimal cardLimit;
  @ManyToOne(fetch = FetchType.LAZY)
  private User userID;
  @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
  private List<Expense> expenseIDs;
}
