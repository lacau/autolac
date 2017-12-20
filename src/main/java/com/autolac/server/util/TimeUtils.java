package com.autolac.server.util;

import java.util.concurrent.TimeUnit;

/**
 * Created by lacau on 20/12/17.
 */
public class TimeUtils {

  private TimeUtils() {
    throw new IllegalStateException("TimeUtils class shouldn't be instantiated!");
  }

  public static final long getMilisecondsByTimeUnit(final long value, final TimeUnit timeUnit) {
    switch (timeUnit) {
    case SECONDS:
      return value * 1000;
    case MINUTES:
      return value * 1000 * 60;
    case HOURS:
      return value * 1000 * 60 * 60;
    case DAYS:
      return value * 1000 * 60 * 60 * 24;
    }

    return value;
  }
}
