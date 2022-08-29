package com.finantialcontrol.core.usecases.user;

import com.finantialcontrol.core.domain.Identity;
import com.finantialcontrol.core.domain.User;
import java.util.Optional;

public interface UserRepository {
  User save(User user);

  Optional<User> getById(Long id);

  Optional<User> getByEmail(String email);

  boolean existsByEmail(String email);
}
