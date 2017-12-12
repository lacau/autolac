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

  public static String generateToken(final Credential credential) {
    final StringBuilder sb = new StringBuilder();
    sb.append(credential.getLogin());
    sb.append(":");
    sb.append(credential.getPassword());
    sb.append(":");
    sb.append(System.currentTimeMillis());

    final byte[] bytes = encryptValue(sb.toString(), SHA_256);
    return convertToHex(bytes);
  }

  public static String generateSHA256Password(final String password) {
    return convertToHex(encryptValue(password, SHA_256));
  }

  private static String convertToHex(final byte[] raw) {
    final StringBuilder sb = new StringBuilder();

    for (int i = 0; i < raw.length; i++) {
      sb.append(Integer.toString((raw[i] & 0xff) + 0x100, 16).substring(1));
    }

    return sb.toString();
  }

  private static byte[] encryptValue(final String value, final String algorithm) {
    MessageDigest md;

    try {
      md = MessageDigest.getInstance(algorithm);
      return md.digest(value.getBytes());
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return null;
  }
}