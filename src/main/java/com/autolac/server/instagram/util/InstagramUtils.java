package com.autolac.server.instagram.util;

import com.eaio.uuid.UUID;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lacau on 02/01/18.
 */
public final class InstagramUtils {

  private static final String ALGORITHM = "MD5";

  private static final Charset CHARTSET = Charset.forName("UTF-8");

  private static final String HEX_CHARS = "0123456789abcdef";

  private InstagramUtils() {
    throw new IllegalStateException("InstagramUtils class shouldn't be instantiated!");
  }

  public static String generateDeviceId(final String username, final String password) {
    final String seed = generateMD5(username + password);
    final String additionalSeed = "12345";

    return "android-" + generateMD5(seed + additionalSeed).substring(0, 16);
  }

  public static String generateUuid() {
    return new UUID().toString();
  }

  private static String generateMD5(final String value) {
    try {
      final MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
      final byte[] digest = messageDigest.digest(value.getBytes(CHARTSET));

      return generateHex(digest, digest.length);
    } catch (NoSuchAlgorithmException nsae) {
      throw new RuntimeException("MD5 algorithm not available");
    }
  }

  private static String generateHex(final byte[] bytes, final int start) {
    final int min = Math.min(start, bytes.length);
    final char[] chars = new char[min * 2];

    for (int i = 0; i < min; ++i) {
      int val = bytes[i];
      if (val < 0) {
        val += 256;
      }
      chars[(2 * i)] = HEX_CHARS.charAt(val / 16);
      chars[(2 * i + 1)] = HEX_CHARS.charAt(val % 16);
    }

    return new String(chars);
  }
}
