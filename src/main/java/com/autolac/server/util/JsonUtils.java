package com.autolac.server.util;

import com.autolac.server.exception.HttpException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by lacau on 14/12/17.
 */
public class JsonUtils {

  private static ObjectMapper mapper;

  static {
    mapper = new ObjectMapper();
    mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
  }

  private JsonUtils() {
    throw new IllegalStateException("JsonUtils class shouldn't be instantiated!");
  }

  public static String convertObjectToJson(final Object object) throws JsonProcessingException {
    if (object == null) {
      return null;
    }

    return mapper.writerWithView(HttpException.Show.class).writeValueAsString(object);
  }
}
