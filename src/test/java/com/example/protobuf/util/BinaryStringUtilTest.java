package com.example.protobuf.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryStringUtilTest {

  @Test
  public void byte_array_equals_테스트() {
    byte[] bytes1 = {1, 2, 3};
    byte[] bytes2 = {1, 2, 3};

    assertThat(Arrays.equals(bytes1, bytes2)).isEqualTo(true);
    assertThat(bytes1 == bytes2).isEqualTo(false);
    assertThat(bytes1.hashCode() == bytes2.hashCode()).isEqualTo(false);
  }

  @Test
  public void byteArrayToBinaryString_binaryStringToByteArray_테스트() {
    byte[] originBytes = {1, 2, 3};
    String originBinaryString = BinaryStringUtil.byteArrayToBinaryString(originBytes);
    byte[] targetBytes = BinaryStringUtil.binaryStringToByteArray(originBinaryString);

    assertThat(Arrays.equals(targetBytes, originBytes)).isEqualTo(true);
  }

}