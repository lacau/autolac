package com.autolac.server.converter;

import com.autolac.server.cache.CredentialCache;
import com.autolac.server.domain.entity.Credential;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 20/12/17.
 */
@Component
public class CredentialCacheConverter {

  public CredentialCache convert(final Credential credential) {
    CredentialCache credentialCache = new CredentialCache();
    credentialCache.id = credential.getId();
    credentialCache.token = credential.getToken();
    credentialCache.tokenDate = credential.getTokenDate().getTime();

    return credentialCache;
  }
}
