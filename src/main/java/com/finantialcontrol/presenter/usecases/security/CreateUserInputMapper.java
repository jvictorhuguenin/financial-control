package com.finantialcontrol.presenter.usecases.security;

import com.finantialcontrol.core.usecases.user.CreateUserUseCase;
import com.finantialcontrol.presenter.api.entities.SignUpRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserInputMapper {
  private final PasswordEncoder passwordEncoder;

  public CreateUserInputMapper(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  public CreateUserUseCase.InputValues map(SignUpRequest signUpRequest){
    return new CreateUserUseCase.InputValues(
        signUpRequest.getFirstName(),
        signUpRequest.getLastName(),
        signUpRequest.getUsername(),
        signUpRequest.getEmail(),
        passwordEncoder.encode(signUpRequest.getPassword())
    );
  }
}
