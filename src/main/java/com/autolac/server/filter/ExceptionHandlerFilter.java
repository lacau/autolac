package com.autolac.server.filter;

import com.autolac.server.exception.HttpException;
import com.autolac.server.util.JsonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lacau on 13/12/17.
 */
@Component
public class ExceptionHandlerFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    try {
      filterChain.doFilter(request, response);
    } catch (HttpException e) {
      response.setStatus(e.getHttpStatus().value());
      response.getWriter().write(JsonUtils.convertObjectToJson(e));
    } catch (RuntimeException e) {
      response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
      response.getWriter().write(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }
  }
}