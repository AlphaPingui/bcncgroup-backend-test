package com.test.similarproducts.exception;

import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(WebClientResponseException.NotFound.class)
  public ResponseEntity<Object> handleNotFound(
      WebClientResponseException.NotFound ex, WebRequest request) {
    return buildResponse(HttpStatus.NOT_FOUND, "Resource not found");
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
    return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error occurred");
  }

  private ResponseEntity<Object> buildResponse(HttpStatus status, String message) {
    Map<String, Object> body =
        Map.of(
            "timestamp", LocalDateTime.now(),
            "status", status.value(),
            "error", status.getReasonPhrase(),
            "message", message);
    return new ResponseEntity<>(body, status);
  }
}
