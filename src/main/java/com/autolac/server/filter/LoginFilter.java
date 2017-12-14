package com.autolac.server.filter;

import com.autolac.server.security.CredentialValidator;
import com.autolac.server.exception.InvalidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by lacau on 13/12/17.
 */
@Component
public class LoginFilter extends OncePerRequestFilter {

  private Collection<String> excludeUrlPatterns;

  private PathMatcher pathMatcher = new AntPathMatcher();

  @Autowired
  private CredentialValidator credentialValidator;

  @Override
  protected void initFilterBean() throws ServletException {
    super.initFilterBean();
    excludeUrlPatterns = new ArrayList<>();
    excludeUrlPatterns.add("/login/*");
    excludeUrlPatterns.add("/account/*");
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    final String authId = request.getHeader("auth_id");
    final String authToken = request.getHeader("auth_token");
    if (authId == null || authToken == null)
      throw new InvalidCredentialException();

    if (!credentialValidator.isCredentialValid(authId, authToken))
      throw new InvalidCredentialException();
  }

  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
    return excludeUrlPatterns.stream()
        .anyMatch(p -> pathMatcher.match(p, request.getServletPath()));
  }
}
