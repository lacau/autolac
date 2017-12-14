package com.autolac.server.controller;

import com.autolac.server.exception.HttpException;
import com.autolac.server.util.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by lacau on 14/12/17.
 */
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(HttpException.class)
  public ResponseEntity<Object> httpExcetionHandler(HttpException e, WebRequest request)
      throws JsonProcessingException {

    return handleExceptionInternal(e, JsonUtils.convertObjectToJson(e),
        new HttpHeaders(), e.getHttpStatus(), request);
  }
}
