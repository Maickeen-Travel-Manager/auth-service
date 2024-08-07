package nl.com.amaro.auth_service.controller;

import nl.com.amaro.auth_service.dto.UserRegistrationDTO;
import nl.com.amaro.auth_service.model.User;
import nl.com.amaro.auth_service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
    User registeredUser = userService.registerUser(userRegistrationDTO);
    return ResponseEntity.ok(registeredUser);
  }
}
