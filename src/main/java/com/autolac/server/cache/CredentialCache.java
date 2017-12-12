package com.autolac.server.cache;

import java.io.Serializable;

/**
 * Created by lacau on 11/12/17.
 */
public class CredentialCache implements Serializable {

  public Long id;

  public String token;

  public Long tokenDate;
}