package com.bc.album.infrastructure.rest.spring.resource;

import java.time.Instant;
import java.util.function.Supplier;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * TimedRequest class.
 *
 * @author Álvaro Carmona.
 * @since 25/01/2024
 *
 * @param <I> The Input request.
 * @param <O> The Output response.
 *
 */
@Log4j2
@AllArgsConstructor
public class TimedRequest<I, O> {
  private final String requestName;
  private final I request;

  /**
   * Handles a request and takes care about the timing. The time is written into the log.
   *
   * @param supplier The supplier for processing the request.
   * @return The result generated by the supplier.
   */
  public O handle(Supplier<O> supplier) {
    Instant start = Instant.now();
    log.info("Request start: {}.", requestName);
    boolean succeeded = false;
    O response = null;
    try {
      response = supplier.get();
      succeeded = true;
      return response;
    } finally {
      Instant end = Instant.now();
      log.info("Request end: {}. Successful? {}. Elapsed time {}ms",
              requestName,
              succeeded,
              end.minusMillis(start.toEpochMilli()).toEpochMilli());
    }
  }

}
