package com.finantialcontrol.core.usecases.user;

import com.finantialcontrol.core.domain.User;
import com.finantialcontrol.core.domain.exceptions.EmailAlreadyUsedException;
import com.finantialcontrol.core.usecases.UseCase;
import lombok.Value;

public class CreateUserUseCase extends UseCase<CreateUserUseCase.InputValues, CreateUserUseCase.OutputValues> {
  private final UserRepository repository;

  public CreateUserUseCase(UserRepository userRepository) {
    this.repository = userRepository;
  }

  @Override
  public OutputValues execute(InputValues input) {
    if (repository.existsByEmail(input.getEmail())) {
      throw new EmailAlreadyUsedException("Email address already in use!");
    }

    User user = User.newInstance(
        input.firstName,
        input.lastName,
        input.username,
        input.email,
        input.password
    );

    return new OutputValues(repository.save(user));
  }

  @Value
  public static class InputValues implements UseCase.InputValues{
    String firstName;
    String lastName;
    String username;
    String email;
    String password;
  }

  @Value
  public static class OutputValues implements UseCase.OutputValues{
    User user;
  }
}
