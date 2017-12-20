package com.autolac.server.service;

import com.autolac.server.cache.CacheManager;
import com.autolac.server.converter.CredentialCacheConverter;
import com.autolac.server.domain.entity.Credential;
import com.autolac.server.domain.repository.CredentialRepository;
import com.autolac.server.exception.InvalidCredentialException;
import com.autolac.server.security.CredentialValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lacau on 20/12/17.
 */
@Service
public class LoginServiceImpl implements LoginService {

  @Autowired
  private CredentialRepository credentialRepository;

  @Autowired
  private CredentialCacheConverter credentialCacheConverter;

  @Autowired
  private CacheManager cacheManager;

  @Autowired
  private CredentialValidator credentialValidator;

  public void doLoginByToken(final Credential credential) {
    final Credential credentialDB = credentialRepository.findByIdAndToken(credential.getId(), credential.getToken());
    if (credentialDB == null)
      throw new InvalidCredentialException();

    cacheManager.store(credentialCacheConverter.convert(credentialDB));
  }
}