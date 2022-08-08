package com.finantialcontrol.dtos;

import java.util.Set;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {
  @NotEmpty
  private String firstName;
  @NotEmpty
  private String lastName;
  @NotEmpty
  private String username;
  @NotEmpty
  private String email;
  @NotEmpty
  private String password;
  private Set<String> roles;
}
