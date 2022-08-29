package com.finantialcontrol.presenter.api.user;

import com.finantialcontrol.presenter.api.entities.ApiResponse;
import com.finantialcontrol.presenter.api.entities.SignUpRequest;
import java.util.concurrent.CompletableFuture;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public interface UserResource {

  @PostMapping("/registry")
  CompletableFuture<ResponseEntity<ApiResponse>> signUp(@Valid @RequestBody SignUpRequest request, HttpServletRequest httpServletRequest);
}
