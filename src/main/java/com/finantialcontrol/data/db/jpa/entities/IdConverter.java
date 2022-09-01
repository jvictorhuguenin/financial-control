package com.finantialcontrol.data.db.jpa.entities;

import com.finantialcontrol.core.domain.Identity;

public class IdConverter {
  public static Long convertId(Identity id) {
    if (id != null && id.getNumber() != Long.MIN_VALUE) {
      return id.getNumber();
    }

    return null;
  }
}
