package com.autolac.server.json;

import java.io.Serializable;

/**
 * Created by lacau on 14/12/17.
 */
public class CredentialOut implements Serializable {

  private Long id;

  private String token;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
