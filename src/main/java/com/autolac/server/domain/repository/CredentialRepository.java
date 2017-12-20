package com.autolac.server.domain.repository;

import com.autolac.server.domain.entity.Credential;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by lacau on 11/12/17.
 */
public interface CredentialRepository extends CrudRepository<Credential, Long> {

  @Query("SELECT count(credential.id) FROM Credential credential "
      + "WHERE credential.login = :login")
  Long countByLogin(@Param("login") final String login);

  @Query("SELECT credential FROM Credential credential "
      + "WHERE credential.id = :id "
      + "AND credential.token = :token")
  Credential findByIdAndToken(@Param("id") final long id, @Param("token") final String token);
}