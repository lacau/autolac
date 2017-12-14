package com.autolac.server.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by lacau on 13/12/17.
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class InvalidCredentialException extends RuntimeException {
}
