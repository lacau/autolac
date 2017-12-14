package com.autolac.server.exception;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;

/**
 * Created by lacau on 13/12/17.
 */
public abstract class HttpException extends RuntimeException {

  @JsonView(Show.class)
  public abstract HttpStatus getHttpStatus();

  @JsonView(Show.class)
  public abstract String getReason();

  public static final class Show {
  }
}
