package com.autolac.server.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;

/**
 * Created by lacau on 13/12/17.
 */
public abstract class HttpException extends RuntimeException {

  private HttpStatus httpStatus;

  private String reason;

  public HttpException(HttpStatus httpStatus, String reason) {
    this.httpStatus = httpStatus;
    this.reason = reason;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  @JsonView(Show.class)
  @JsonProperty("httpStatus")
  public int getHttpStatusCode() {
    return httpStatus.value();
  }

  @JsonView(Show.class)
  public String getReason() {
    return reason;
  }

  public static final class Show {
  }
}
