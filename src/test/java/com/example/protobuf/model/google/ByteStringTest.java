package com.example.protobuf.model.google;

import com.google.protobuf.ByteString;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static com.example.protobuf.util.ByteStringUtil.getTestBytes;
import static org.assertj.core.api.Assertions.assertThat;

public class ByteStringTest {

  @Test
  public void testCompare_equalByteStrings_compareEqual() throws Exception {
    byte[] referenceBytes = getTestBytes();
    ByteString string1 = ByteString.copyFrom(referenceBytes);
    ByteString string2 = ByteString.copyFrom(referenceBytes);

    assertThat(ByteString.unsignedLexicographicalComparator().compare(string1, string2)).isEqualTo(0);
  }

  @Test
  public void testCompare_byteStringsSortLexicographically() throws Exception {
    ByteString app = ByteString.copyFromUtf8("app");
    ByteString apple = ByteString.copyFromUtf8("apple");
    ByteString banana = ByteString.copyFromUtf8("banana");

    Comparator<ByteString> comparator = ByteString.unsignedLexicographicalComparator();


    assertThat(comparator.compare(app, apple) < 0)
      .isTrue();

    assertThat(comparator.compare(app, banana) < 0)
      .isTrue();

    assertThat(comparator.compare(apple, banana) < 0)
      .isTrue();
  }

  @Test
  public void testCompare_interpretsByteValuesAsUnsigned() throws Exception {
    // Two's compliment of `-1` == 0b11111111 == 255
    ByteString twoHundredFiftyFive = ByteString.copyFrom(new byte[]{-1});
    // 0b00000001 == 1
    ByteString one = ByteString.copyFrom(new byte[]{1});

    assertThat(ByteString.unsignedLexicographicalComparator().compare(one, twoHundredFiftyFive) < 0)
      .isTrue();
  }

  @Test
  public void maxLenBytes() throws Exception {
    byte[] testBytes = getTestBytes(16);
    ByteString maxLenByteString = ByteString.copyFrom(testBytes);
    String str = maxLenByteString.toString();
    System.out.println(str);
    System.out.println(maxLenByteString.toStringUtf8());
  }

}
