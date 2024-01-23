package com.bc.album.application.exception;

/**
 * ApiExchangeException class.
 * In com.bc.album.application.exception.
 * @author Álvaro Carmona
 * @since 23/01/2024
 */
public class ApiExchangeException extends ApiErrorException {

  private static final long serialVersionUID = 1L;

  /**
   * Creates a ApiExchangeException.
   * @param field The missing header.
   * @param cause The error.
   */
  public ApiExchangeException(String field, Throwable cause) {
    super(ErrorCode.API_EXCHANGE_ERROR, field, cause);
  }

}
