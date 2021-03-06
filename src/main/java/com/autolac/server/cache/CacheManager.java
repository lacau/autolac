package com.autolac.server.cache;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 11/12/17.
 */
@Component
public class CacheManager {

  private JCS cache;

  public CacheManager() {
    try {
      cache = JCS.getInstance("default");
    } catch (CacheException e) {
      e.printStackTrace();
    }
  }

  public void store(final CredentialCache value) {
    try {
      cache.put(value.id, value);
    } catch (CacheException e) {
      e.printStackTrace();
    }
  }

  public CredentialCache retrieve(final Long key) {
    final Object value = cache.get(key);
    return value != null ? (CredentialCache) value : null;
  }

  public void remove(final Long key) {
    try {
      cache.remove(key);
    } catch (CacheException e) {
      e.printStackTrace();
    }
  }
}