package com.autolac.server.security;

import com.autolac.server.cache.CacheManager;
import com.autolac.server.cache.CredentialCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 13/12/17.
 */
@Component
public class CredentialValidator {

  // mili * sec * hour * day
  private static final long TOKEN_LIVE = 1000 * 3600 * 24 * 7;

  @Autowired
  private CacheManager cacheManager;

  public boolean isCredentialValid(final String authId, final String authToken) {
    long id;
    try {
      id = Long.valueOf(authId);
    } catch (NumberFormatException e) {
      return false;
    }

    final CredentialCache credentialCache = cacheManager.retrieve(id);
    if (credentialCache == null || !credentialCache.token.equals(authToken))
      return false;

    return isValidToken(credentialCache.tokenDate);
  }

  public boolean isValidToken(Long tokenDate) {
    return System.currentTimeMillis() < tokenDate + TOKEN_LIVE;
  }
}
