package com.autolac.server.filter;

import com.autolac.server.HttpException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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

  private ObjectMapper mapper;

  @Override
  protected void initFilterBean() throws ServletException {
    super.initFilterBean();
    mapper = new ObjectMapper();
    mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    try {
      filterChain.doFilter(request, response);
    } catch (HttpException e) {
      response.setStatus(e.getHttpStatus().value());
      response.getWriter().write(convertObjectToJson(e));
    } catch (RuntimeException e) {
      response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
      response.getWriter().write(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }
  }

  private String convertObjectToJson(final Object object) throws JsonProcessingException {
    if (object == null) {
      return null;
    }

    return mapper.writerWithView(HttpException.Show.class).writeValueAsString(object);
  }
}