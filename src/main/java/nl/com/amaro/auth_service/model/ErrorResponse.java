package nl.com.amaro.auth_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

  private int code;
  private String message;

}
