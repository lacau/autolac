package com.autolac.server.domain.repository;

import com.autolac.server.domain.entity.Credential;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lacau on 11/12/17.
 */
public interface CredentialRepository extends CrudRepository<Credential, Long> {
}