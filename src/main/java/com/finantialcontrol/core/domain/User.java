package com.finantialcontrol.core.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Setter
@ToString
public class User {
  private Identity id;
  private String firstName;
  private String lastName;
  private String username;
  private String email;
  private String password;
  private UserStatus userStatus;

  public static User newInstance(final String firstName, final String lastName, final String username,
                                 final String email, final String password) {
    return new User(
        Identity.nothing(),
        firstName,
        lastName,
        username,
        email,
        password,
        UserStatus.ENABLED
    );
  }

}
