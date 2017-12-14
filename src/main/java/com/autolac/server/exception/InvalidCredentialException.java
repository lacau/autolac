package com.autolac.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by lacau on 13/12/17.
 */
public class InvalidCredentialException extends HttpException {

  public InvalidCredentialException() {
    super(HttpStatus.UNAUTHORIZED, "Invalid credential");
  }
}
