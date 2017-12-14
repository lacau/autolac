package com.autolac.server.config;

import com.autolac.server.filter.ExceptionHandlerFilter;
import com.autolac.server.filter.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * Created by lacau on 13/12/17.
 */
@Configuration
public class FilterConfig {

  @Autowired
  private ExceptionHandlerFilter exceptionHandlerFilter;

  @Autowired
  private LoginFilter loginFilter;

  @Bean
  public FilterRegistrationBean exceptionHandlerFilterRegister() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(exceptionHandlerFilter);
    registration.addUrlPatterns("/*");
    registration.setName(exceptionHandlerFilter.getClass().getSimpleName());
    registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return registration;
  }

  @Bean
  public FilterRegistrationBean loginFilterRegister() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(loginFilter);
    registration.addUrlPatterns("/*");
    registration.setName(loginFilter.getClass().getSimpleName());
    registration.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
    return registration;
  }
}
