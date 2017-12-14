package com.autolac.server.service;

import com.autolac.server.json.CredentialIn;
import com.autolac.server.json.CredentialOut;

/**
 * Created by lacau on 14/12/17.
 */
public interface CredentialService {

  CredentialOut createCredential(final CredentialIn credentialIn);
}
