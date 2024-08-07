package nl.com.amaro.auth_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import nl.com.amaro.auth_service.dto.UserRegistrationDTO;
import nl.com.amaro.auth_service.model.ErrorResponse;
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

  @Operation(summary = "Register a new user", description = "Registers a new user with a unique username and email")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "User registered successfully",
                   content = { @Content(mediaType = "application/json",
                                        schema = @Schema(implementation = User.class)) }),
      @ApiResponse(responseCode = "400", description = "Invalid input",
                   content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
      @ApiResponse(responseCode = "409", description = "User already exists",
                   content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
  })
  @PostMapping("/register")
  public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
    User registeredUser = userService.registerUser(userRegistrationDTO);
    return ResponseEntity.ok(registeredUser);
  }
}
