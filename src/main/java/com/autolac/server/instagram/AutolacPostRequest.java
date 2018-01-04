package com.autolac.server.instagram;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicHeader;
import org.springframework.http.HttpMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lacau on 04/01/18.
 */
public class AutolacPostRequest<T> extends AutolacRequest<T> {

  private final List<Header> headers;

  public AutolacPostRequest() {
    headers = new ArrayList<>();
    headers.add(new BasicHeader("Connection", "close"));
    headers.add(new BasicHeader("Accept", "*/*"));
    headers.add(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"));
    headers.add(new BasicHeader("Cookie2", "$Version=1"));
    headers.add(new BasicHeader("Accept-Language", "en-US"));
    headers.add(new BasicHeader("User-Agent", InstagramConstants.USER_AGENT));
  }

  @Override
  public String getMethod() {
    return HttpMethod.POST.name();
  }

  @Override
  public String getUrl() {
    return null;
  }

  @Override
  public T execute() {
    HttpPost post = new HttpPost(InstagramConstants.API_URL + getUrl());
    for (Header header : headers) {
      post.addHeader(header);
    }

    // TODO add response parse
    return null;
  }
}
