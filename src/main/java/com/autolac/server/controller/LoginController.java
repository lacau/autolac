package com.autolac.server.controller;

import com.autolac.server.domain.entity.Credential;
import com.autolac.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lacau on 20/12/17.
 */
@RestController
@RequestMapping("login")
public class LoginController {

  @Autowired
  private LoginService loginService;

  @RequestMapping(value = "/token", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity byToken(@RequestHeader("auth_token") String authToken, @RequestHeader("auth_id") Long authId) {
    if (authToken == null || authId == null)
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED.value()).build();

    final Credential credential = new Credential();
    credential.setId(authId);
    credential.setToken(authToken);

    loginService.doLoginByToken(credential);

    return ResponseEntity.ok().build();
  }

  @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity logout(@RequestHeader("auth_token") String authToken, @RequestHeader("auth_id") Long authId) {
    final Credential credential = new Credential();
    credential.setId(authId);
    credential.setToken(authToken);

    loginService.doLogout(credential);

    return ResponseEntity.ok().build();
  }
}
