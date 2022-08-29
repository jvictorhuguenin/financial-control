package com.finantialcontrol.presenter.api.entities;

import com.finantialcontrol.core.usecases.user.CreateUserUseCase;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Value;

@Value
public class SignUpRequest {
  @NotBlank
  @Size(max = 20)
  String firstName;

  @NotBlank
  @Size(max = 30)
  String lastName;

  @NotBlank
  @Size(max = 30)
  String username;

  @Email
  @NotBlank
  @Size(max = 100)
  String email;

  @NotBlank
  @Size(min = 6, max = 50)
  String password;

  public static CreateUserUseCase.InputValues from(SignUpRequest signUpRequest) {
    return new CreateUserUseCase.InputValues(
        signUpRequest.getFirstName(),
        signUpRequest.getLastName(),
        signUpRequest.getUsername(),
        signUpRequest.getEmail(),
        signUpRequest.getPassword()
    );
  }
}
