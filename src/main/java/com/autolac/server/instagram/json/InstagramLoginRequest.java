package com.autolac.server.instagram.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by lacau on 02/01/18.
 */
public class InstagramLoginRequest {

  @JsonProperty("username")
  private String userName;

  @JsonProperty("phone_id")
  private String phoneId;

  @JsonProperty("_csrftoken")
  private String csrfToken;

  @JsonProperty("guid")
  private String gUID;

  @JsonProperty("device_id")
  private String deviceId;

  @JsonProperty("password")
  private String password;

  @JsonProperty("login_attempt_account")
  private int loginAttemptAccount;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPhoneId() {
    return phoneId;
  }

  public void setPhoneId(String phoneId) {
    this.phoneId = phoneId;
  }

  public String getCsrfToken() {
    return csrfToken;
  }

  public void setCsrfToken(String csrfToken) {
    this.csrfToken = csrfToken;
  }

  public String getgUID() {
    return gUID;
  }

  public void setgUID(String gUID) {
    this.gUID = gUID;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getLoginAttemptAccount() {
    return loginAttemptAccount;
  }

  public void setLoginAttemptAccount(int loginAttemptAccount) {
    this.loginAttemptAccount = loginAttemptAccount;
  }
}
