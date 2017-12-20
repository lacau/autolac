package com.autolac.server.security;

import com.autolac.server.cache.CacheManager;
import com.autolac.server.cache.CredentialCache;
import com.autolac.server.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by lacau on 13/12/17.
 */
@Component
public class CredentialValidator {

  @Value("${token.expiration.time.days:7}")
  private long tokenExpirationTime;

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

  public boolean isValidToken(final Long tokenDate) {
    return System.currentTimeMillis() < tokenDate + TimeUtils
        .getMilisecondsByTimeUnit(tokenExpirationTime, TimeUnit.DAYS);
  }
}
