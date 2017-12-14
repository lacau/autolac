package com.autolac.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by lacau on 13/12/17.
 */
public class InvalidCredentialException extends HttpException {

  @Override
  public HttpStatus getHttpStatus() {
    return HttpStatus.UNAUTHORIZED;
  }

  @Override
  public String getReason() {
    return "Invalid credential";
  }
}
