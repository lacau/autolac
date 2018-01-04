package com.autolac.server.instagram;

/**
 * Created by lacau on 04/01/18.
 */
public abstract class AutolacRequest<T> {

  public abstract String getUrl();

  public abstract String getMethod();

  public String getPayload() {
    return null;
  }

  public abstract T execute();
}
