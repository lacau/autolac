package com.autolac.server.controller;

import com.autolac.server.json.CredentialIn;
import com.autolac.server.json.CredentialOut;
import com.autolac.server.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by lacau on 14/12/17.
 */
@RestController
@RequestMapping("credential")
public class CredentialController {

  @Autowired
  private CredentialService credentialService;

  @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public CredentialOut createCredential(@RequestBody @Valid @NotNull CredentialIn credentialIn) {
    return credentialService.createCredential(credentialIn);
  }
}