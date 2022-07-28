package com.finantialcontrol.repository;

import com.finantialcontrol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
