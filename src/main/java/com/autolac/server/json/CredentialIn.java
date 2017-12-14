package com.autolac.server.json;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by lacau on 14/12/17.
 */
public class CredentialIn implements Serializable {

  @NotBlank
  private String login;

  @NotBlank
  private String password;

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
