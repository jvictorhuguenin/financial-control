package com.finantialcontrol.core.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@Value
public class Identity {
  Long id;

  public static Identity nothing() {
    return new Identity(Long.MIN_VALUE);
  }
}
