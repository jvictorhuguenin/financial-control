package com.finantialcontrol.core.domain;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Value;

@Value
public class Identity {
  Long id;

  public Long getNumber() {
    return id;
  }

  public static Identity nothing() {
    return new Identity(Long.MIN_VALUE);
  }
}
