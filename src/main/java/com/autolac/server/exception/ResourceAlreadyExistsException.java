package com.autolac.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by lacau on 14/12/17.
 */
public class ResourceAlreadyExistsException extends HttpException {

  public ResourceAlreadyExistsException() {
    super(HttpStatus.CONFLICT, "Resource already exists");
  }
}