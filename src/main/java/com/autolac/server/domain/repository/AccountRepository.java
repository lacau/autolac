package com.autolac.server.domain.repository;

import com.autolac.server.domain.entity.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lacau on 11/12/17.
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
}