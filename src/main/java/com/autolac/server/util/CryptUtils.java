package com.autolac.server.util;

import com.autolac.server.domain.entity.Credential;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lacau on 11/12/17.
 */
public final class CryptUtils {

  private static final String SHA_256 = "SHA-256";

  private CryptUtils() {
    throw new IllegalStateException("CryptUtils class shouldn't be instantiated!");
  }

  public static String generateToken(Credential credential) {
    StringBuilder sb = new StringBuilder();
    sb.append(credential.getLogin());
    sb.append(":");
    sb.append(credential.getPassword());
    sb.append(":");
    sb.append(System.currentTimeMillis());

    byte[] bytes = encryptValue(sb.toString(), SHA_256);
    return convertToHex(bytes);
  }

  public static String generateSHA256Password(String password) {
    return convertToHex(encryptValue(password, SHA_256));
  }

  private static String convertToHex(byte[] raw) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < raw.length; i++) {
      sb.append(Integer.toString((raw[i] & 0xff) + 0x100, 16).substring(1));
    }

    return sb.toString();
  }

  private static byte[] encryptValue(String value, String algorithm) {
    MessageDigest md = null;

    try {
      md = MessageDigest.getInstance(algorithm);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return md.digest(value.getBytes());
  }
}