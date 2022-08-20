package com.finantialcontrol.service.authentication;

import com.finantialcontrol.mapper.UserMapper;
import com.finantialcontrol.model.User;
import com.finantialcontrol.repository.UserRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class DatabaseUserDetailsPasswordService implements
    UserDetailsPasswordService {
  private final UserRepository userRepository;
  private final UserDetailsMapper userDetailsMapper;

  @Autowired
  public DatabaseUserDetailsPasswordService(UserRepository userRepository, UserDetailsMapper userDetailsMapper) {
    this.userRepository = userRepository;
    this.userDetailsMapper = userDetailsMapper;
  }

  @Override
  public UserDetails updatePassword(UserDetails userDetails, String newPassword) {
    User user = userRepository.findByUsername(userDetails.getUsername());
    user.setHash(newPassword);
    return userDetailsMapper.toUserDetails(UserMapper.INSTANCE.userToUserPostDto(user));
  }
}
