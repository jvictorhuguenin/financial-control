package com.finantialcontrol.core.usecases.user;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;

import com.finantialcontrol.core.domain.User;
import com.finantialcontrol.core.domain.exceptions.EmailAlreadyUsedException;
import com.finantialcontrol.core.usecases.entity.EntityGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateUserUseCaseTest {
  @InjectMocks
  private CreateUserUseCase createUserUseCase;

  @Mock
  private UserRepository userRepository;

  @Test
  public void shouldThrowEmailAlreadyTaken(){
    //given
    CreateUserUseCase.InputValues inputValues = new CreateUserUseCase.InputValues("test",
        "lastName", "username",
        "test@test.com","testpassword"
    );

    //and
    Mockito.doReturn(true)
        .when(userRepository)
        .existsByEmail(inputValues.getEmail());

    //then
    Assertions.assertThrows(EmailAlreadyUsedException.class,
        ()-> createUserUseCase.execute(inputValues));
  }

  @Test
  public void shouldReturnUser(){
    //given
    User user = EntityGenerator.createRandomUser();
    User toBeMatched = User.newInstance(
        user.getFirstName(), user.getLastName(),
        user.getUsername(), user.getEmail(),
        user.getPassword()
    );
    CreateUserUseCase.InputValues input = new CreateUserUseCase.InputValues(
        user.getFirstName(), user.getLastName(),
        user.getUsername(), user.getEmail(),
        user.getPassword()
    );

    //and
    doReturn(user)
        .when(userRepository)
        .save(eq(toBeMatched));

    //when
    User actual = createUserUseCase.execute(input).getUser();

    //then
    Assertions.assertEquals(actual, user);
  }
}
