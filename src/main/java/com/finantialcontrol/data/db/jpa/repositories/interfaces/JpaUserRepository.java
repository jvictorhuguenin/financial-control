package com.finantialcontrol.data.db.jpa.repositories.interfaces;

import com.finantialcontrol.data.db.jpa.entities.UserData;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserData, Long> {
  boolean existsByEmail(String email);

  Optional<UserData> findByEmail(String email);
}
