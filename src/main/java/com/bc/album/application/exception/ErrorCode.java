package com.bc.album.application.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
  UNHANDLED_ERROR(
          "00500000",
          HttpStatus.INTERNAL_SERVER_ERROR,
          ErrorLevel.FATAL,
          "Unhandled Error",
          "Unhandled Error: %s"),
  HEADER_FIELD_MISSING(
      "01400001",
      HttpStatus.BAD_REQUEST,
      ErrorLevel.FATAL,
      "Header field missing",
      "Header field [%s] is missing"),
  INVALID_REQUEST_BODY(
          "01400002",
          HttpStatus.BAD_REQUEST,
          ErrorLevel.FATAL,
          "Invalid request body",
          "Invalid fields detected in the body request: %s"),
  INVALID_REQUEST_HEADER(
          "01400003",
          HttpStatus.BAD_REQUEST,
          ErrorLevel.FATAL,
          "Invalid request header",
          "Invalid request header: %s"),
  FORMATTER_ERROR(
          "02500001",
          HttpStatus.INTERNAL_SERVER_ERROR,
          ErrorLevel.FATAL,
          "Error formatting the result",
          "Unable to convert the result: %s"),
  API_EXCHANGE_ERROR(
          "03500001",
          HttpStatus.INTERNAL_SERVER_ERROR,
          ErrorLevel.FATAL,
          "Error during API communication",
          "Unable to establish API communication: %s");

  /**
   * The code is an 8-digit code with the format LLHHHNNN, where LL is the layer (01 -> application, 02 -> domain,
   * 03 -> infraestructure), HHH is the HTTP result code (400, 502, ...), and the NNN is the error number inside
   * the layer LL.
   */
  private final String code;
  private final HttpStatus status;
  private final ErrorLevel level;
  private final String codeDescription;
  private final String message;
}
