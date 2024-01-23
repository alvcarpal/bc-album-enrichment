package com.bc.album.boot.spring.config;

import org.springframework.classify.Classifier;
import org.springframework.http.HttpStatus;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.policy.NeverRetryPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.web.client.HttpStatusCodeException;
import java.util.Objects;

public class RetryClassifierPolicy implements Classifier<Throwable, RetryPolicy> {
  private final SimpleRetryPolicy simpleRetryPolicy;
  private final NeverRetryPolicy neverRetryPolicy;

  /**
   * Creates a policy for retrying the 503 errors only. It is important to note that the simpleRetryPolicy
   * must be a class attribute. If you create a new one each time the classifier is called then an infinite
   * loop will be created.
   *
   * @param maxRetries The maximum number of retries to execute.
   */
  public RetryClassifierPolicy(int maxRetries) {
    this.simpleRetryPolicy = new SimpleRetryPolicy(maxRetries);
    this.neverRetryPolicy = new NeverRetryPolicy();
  }

  /**
   * Selects the retry policy to apply based on the received throwable.
   *
   * @param throwable The exception.
   * @return The policy to apply.
   */
  @Override
  public RetryPolicy classify(Throwable throwable) {
    if (Objects.nonNull(throwable) && throwable instanceof HttpStatusCodeException) {
      if (((HttpStatusCodeException) throwable).getStatusCode() == HttpStatus.SERVICE_UNAVAILABLE) {
        return simpleRetryPolicy;
      }
    }
    return neverRetryPolicy;
  }
}
