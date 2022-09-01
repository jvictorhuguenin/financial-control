package com.finantialcontrol.presenter.usecases.security;

import com.finantialcontrol.core.domain.User;
import com.finantialcontrol.presenter.api.entities.ApiResponse;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class CreateUserOutputMapper {
  public static ResponseEntity<ApiResponse> map(User user, HttpServletRequest httpServletRequest) {
    URI location = ServletUriComponentsBuilder
        .fromContextPath(httpServletRequest)
        .path("/User/{id}")
        .buildAndExpand(user.getId().getNumber())
        .toUri();

    return ResponseEntity.created(location).body(new ApiResponse(true, "registered successfully"));
  }
}
