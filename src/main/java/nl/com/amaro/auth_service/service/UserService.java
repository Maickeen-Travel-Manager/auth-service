package nl.com.amaro.auth_service.service;

import nl.com.amaro.auth_service.dto.UserRegistrationDTO;
import nl.com.amaro.auth_service.exception.UserAlreadyExistsException;
import nl.com.amaro.auth_service.model.User;
import nl.com.amaro.auth_service.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User registerUser(UserRegistrationDTO userRegistrationDTO) {
    if (userRepository.findByUsername(userRegistrationDTO.getUsername()).isPresent() ||
        userRepository.findByEmail(userRegistrationDTO.getEmail()).isPresent()) {
      throw new UserAlreadyExistsException("User with the same username or email already exists.");
    }

    User user = User.builder()
                    .username(userRegistrationDTO.getUsername())
                    .password(passwordEncoder.encode(userRegistrationDTO.getPassword()))
                    .email(userRegistrationDTO.getEmail())
                    .build();

    return userRepository.save(user);
  }

}
