package com.finantialcontrol.data.db.jpa.repositories;

import com.finantialcontrol.core.domain.User;
import com.finantialcontrol.core.usecases.user.UserRepository;
import com.finantialcontrol.data.db.jpa.entities.UserData;
import com.finantialcontrol.data.db.jpa.repositories.interfaces.JpaUserRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{
  private final JpaUserRepository repository;

  public UserRepositoryImpl(JpaUserRepository repository) {
    this.repository = repository;
  }

  @Override
  public User save(User user) {
    UserData userData = UserData.from(user);
    return repository.save(userData).fromThis();
  }

  @Override
  public Optional<User> getById(Long id) {
    Optional<UserData> optionalUserData = repository.findById(id);
    return optionalUserData.map(UserData::fromThis);
  }

  @Override
  public Optional<User> getByEmail(String email) {
    Optional<UserData> optionalUserData = repository.findByEmail(email);
    return optionalUserData.map(UserData::fromThis);
  }

  @Override
  public boolean existsByEmail(String email) {
    return repository.existsByEmail(email);
  }
}