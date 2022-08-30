package com.finantialcontrol.core.usecases.user;

import com.finantialcontrol.core.domain.exceptions.EmailAlreadyUsedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
public class CreateUserUseCaseTest {
  @InjectMocks
  private CreateUserUseCase createUserUseCase;

  @Mock
  private UserRepository userRepository;

  @Test
  public void shouldThrowAlreadyRegistryEmail(){
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
}
