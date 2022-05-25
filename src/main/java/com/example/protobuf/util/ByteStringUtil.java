package com.example.protobuf.util;

import java.util.Random;

/**
 * Google Protobuf ByteString 타입 유틸리티 클래스
 */
public class ByteStringUtil {

  public static byte[] getTestBytes(int size, long seed) {
    Random random = new Random(seed);
    byte[] result = new byte[size];
    random.nextBytes(result);
    return result;
  }

  public static byte[] getTestBytes(int size) {
    return getTestBytes(size, 445566L);
  }

  public static byte[] getTestBytes() {
    return getTestBytes(1000);
  }

  // Compare the entire left array with a subset of the right array.
  public static boolean isArrayRange(byte[] left, byte[] right, int rightOffset, int length) {
    boolean stillEqual = (left.length == length);
    for(int i = 0; (stillEqual && i < length); i++) {
      stillEqual = (left[i] == right[rightOffset + i]);
    }
    return stillEqual;
  }

  // Returns true only if the given two arrays have identical contents.
  public static boolean isArray(byte[] left, byte[] right) {
    return left.length == right.length && isArrayRange(left, right, 0, left.length);
  }
}
