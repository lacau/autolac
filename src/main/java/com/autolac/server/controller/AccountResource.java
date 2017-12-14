package com.autolac.server.controller;

import com.autolac.server.json.CredentialIn;
import com.autolac.server.json.CredentialOut;
import com.autolac.server.service.AccountService;
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
@RequestMapping("account")
public class AccountResource {

  @Autowired
  private AccountService accountService;

  @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public CredentialOut createAccount(@RequestBody @Valid @NotNull CredentialIn credentialIn) {
    return accountService.createAccount(credentialIn);
  }
}