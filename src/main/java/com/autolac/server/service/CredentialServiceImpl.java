package com.autolac.server.service;

import com.autolac.server.converter.CredentialConverter;
import com.autolac.server.domain.entity.Credential;
import com.autolac.server.domain.repository.CredentialRepository;
import com.autolac.server.exception.ResourceAlreadyExistsException;
import com.autolac.server.json.CredentialIn;
import com.autolac.server.json.CredentialOut;
import com.autolac.server.util.CryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

/**
 * Created by lacau on 14/12/17.
 */
@Service
public class CredentialServiceImpl implements CredentialService {

  @Autowired
  private CredentialRepository credentialRepository;

  @Autowired
  private CredentialConverter credentialConverter;

  @Transactional(propagation = Propagation.REQUIRED)
  public CredentialOut createCredential(final CredentialIn credentialIn) {
    final Long countByLogin = credentialRepository.countByLogin(credentialIn.getLogin());
    if (countByLogin != 0)
      throw new ResourceAlreadyExistsException();

    final Credential credential = new Credential();
    credential.setLogin(credentialIn.getLogin());
    credential.setPassword(CryptUtils.generateSHA256Password(credentialIn.getPassword()));
    credential.setToken(CryptUtils.generateToken(credential));
    credential.setTokenDate(Calendar.getInstance().getTime());

    credentialRepository.save(credential);

    return credentialConverter.convert(credential);
  }
}