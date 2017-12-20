package com.autolac.server.converter;

import com.autolac.server.domain.entity.Credential;
import com.autolac.server.json.CredentialOut;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 14/12/17.
 */
@Component
public class CredentialConverter {

  public CredentialOut convert(final Credential credential) {
    final CredentialOut credentialOut = new CredentialOut();
    credentialOut.setToken(credential.getToken());
    credentialOut.setId(credential.getId());
    return credentialOut;
  }
}
