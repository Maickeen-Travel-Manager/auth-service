package nl.com.amaro.auth_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegistrationDTO {

  private String username;
  private String password;
  private String email;

}
