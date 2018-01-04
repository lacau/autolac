package com.autolac.server.instagram;

/**
 * Created by lacau on 04/01/18.
 */
public interface InstagramConstants {

  String API_URL = "https://i.instagram.com/api/v1/";

  String DEVICE_ANDROID_VERSION = "18";

  String DEVICE_ANDROID_RELEASE = "4.3";

  String DEVICE_MANUFACTURER = "Xiaomi";

  String DEVICE_MODEL = "HM 1SW";

  String USER_AGENT = String
      .format("Instagram 12.0.0.7.91 Android (%s/%s; 320dpi; 720x1280; %s; %s; armani; qcom; en_US)",
          DEVICE_ANDROID_VERSION, DEVICE_ANDROID_RELEASE, DEVICE_MANUFACTURER, DEVICE_MODEL);
}
