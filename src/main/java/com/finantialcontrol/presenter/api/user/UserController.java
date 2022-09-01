package com.finantialcontrol.presenter.api.user;

import com.finantialcontrol.core.usecases.UseCaseExecutor;
import com.finantialcontrol.core.usecases.user.CreateUserUseCase;
import com.finantialcontrol.presenter.api.entities.ApiResponse;
import com.finantialcontrol.presenter.api.entities.SignUpRequest;
import com.finantialcontrol.presenter.usecases.security.CreateUserInputMapper;
import com.finantialcontrol.presenter.usecases.security.CreateUserOutputMapper;
import java.util.concurrent.CompletableFuture;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserController implements UserResource {
  private final UseCaseExecutor useCaseExecutor;
  private final CreateUserUseCase createUserUseCase;
  private final CreateUserInputMapper createUserInputMapper;

  public UserController(UseCaseExecutor useCaseExecutor, CreateUserUseCase createUserUseCase,
                        CreateUserInputMapper createUserInputMapper) {
    this.useCaseExecutor = useCaseExecutor;
    this.createUserUseCase = createUserUseCase;
    this.createUserInputMapper = createUserInputMapper;
  }

  @Override
  public CompletableFuture<ResponseEntity<ApiResponse>> signUp(SignUpRequest request,
                                                               HttpServletRequest httpServletRequest) {
    return useCaseExecutor.execute(
        createUserUseCase,
        createUserInputMapper.map(request),
        (outputValues) -> CreateUserOutputMapper.map(outputValues.getUser(), httpServletRequest)
    );
  }
}
