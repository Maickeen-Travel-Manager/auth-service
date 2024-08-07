package nl.com.amaro.auth_service.exception;

import nl.com.amaro.auth_service.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(UserAlreadyExistsException.class)
  public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
    return new ResponseEntity<>(new ErrorResponse(1, ex.getMessage()), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
    return new ResponseEntity<>(new ErrorResponse(2, ex.getMessage()),
                                HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
