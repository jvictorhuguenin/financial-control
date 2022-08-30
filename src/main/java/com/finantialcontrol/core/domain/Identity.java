package com.finantialcontrol.core.domain;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class Identity {
  private final Long id;

  public Long getNumber() {
    return id;
  }

  public static Identity nothing() {
    return new Identity(Long.MIN_VALUE);
  }
}
