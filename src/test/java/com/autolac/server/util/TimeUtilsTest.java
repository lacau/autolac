package com.autolac.server.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by lacau on 20/12/17.
 */
public class TimeUtilsTest {

  public static final long ONE_SEC_IN_MILI = 1 * 1000;

  public static final long ONE_MIN_IN_MILI = ONE_SEC_IN_MILI * 60;

  public static final long ONE_HOU_IN_MILI = ONE_MIN_IN_MILI * 60;

  public static final long ONE_DAY_IN_MILI = ONE_HOU_IN_MILI * 24;

  @Test
  public void shouldReturnOneSecondInMiliWhenTimeUnitIsSeconds() {
    final long value = TimeUtils.getMilisecondsByTimeUnit(1L, TimeUnit.SECONDS);
    Assert.assertEquals(value, ONE_SEC_IN_MILI);
  }

  @Test
  public void shouldReturnOneMinuteInMiliWhenTimeUnitIsMinutes() {
    final long value = TimeUtils.getMilisecondsByTimeUnit(1L, TimeUnit.MINUTES);
    Assert.assertEquals(value, ONE_MIN_IN_MILI);
  }

  @Test
  public void shouldReturnOneHourInMiliWhenTimeUnitIsSeconds() {
    final long value = TimeUtils.getMilisecondsByTimeUnit(1L, TimeUnit.HOURS);
    Assert.assertEquals(value, ONE_HOU_IN_MILI);
  }

  @Test
  public void shouldReturnOneDayInMiliWhenTimeUnitIsSeconds() {
    final long value = TimeUtils.getMilisecondsByTimeUnit(1L, TimeUnit.DAYS);
    Assert.assertEquals(value, ONE_DAY_IN_MILI);
  }
}
