package com.bc.album.application.handler;

import com.bc.album.application.exception.ApiErrorException;
import com.bc.album.application.exception.HeaderMissingException;
import com.bc.album.application.exception.UnhandledException;
import com.bc.album.application.mapper.ApiErrorMapper;
import com.bc.album.infrastructure.rest.spring.dto.ErrorDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log4j2
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@AllArgsConstructor
public class ErrorHandler {

  private final ApiErrorMapper apiErrorMapper;

  /**
   * Handles unexpected exceptions.
   *
   * @param e The exception.
   * @return The api response.
   */
  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<ErrorDto> handleApiError(Exception e) {
    log.error("Root cause", e);
    return handleApiError(new UnhandledException(e));
  }

  @ExceptionHandler(value = MissingRequestHeaderException.class)
  public ResponseEntity<ErrorDto> handleApiError(MissingRequestHeaderException e) {
    log.error("Root cause", e);
    return handleApiError(new HeaderMissingException(e.getHeaderName(), e));
  }

  /**
   * Handles ApiError exceptions.
   *
   * @param e The api error exception.
   * @return The api response.
   */
  @ExceptionHandler(value = ApiErrorException.class)
  public ResponseEntity<ErrorDto> handleApiError(ApiErrorException e) {
    ErrorDto resp = apiErrorMapper.toApiErrorDto(e);
    log.error("Handling exception. Response: {}, error: ",resp, e);
    return ResponseEntity
            .status(e.getHttpStatus())
            .contentType(MediaType.APPLICATION_PROBLEM_JSON)
            .body(resp);
  }

}
