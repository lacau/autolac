package com.autolac.server.service;

import com.autolac.server.domain.entity.Credential;

/**
 * Created by lacau on 20/12/17.
 */
public interface LoginService {

  void doLoginByToken(final Credential credential);
}