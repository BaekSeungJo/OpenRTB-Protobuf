package com.example.protobuf.model.google;

import com.example.protobuf.util.BinaryStringUtil;
import com.example.protobuf.util.ByteStringUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.ByteString;
import com.google.protobuf.TextFormat;
import com.google.protobuf.util.JsonFormat;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BidRequestTest {

  private BidRequest bidRequest;
  private ObjectMapper objectMapper;

  @BeforeAll
  public void initObjectMapper() {
    objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
  }

  @BeforeAll
  public void initBidRequest() {
    BidRequest.AdSlot adSlot = BidRequest.AdSlot.newBuilder()
      .setId(1)
      .addWidth(320)
      .addHeight(50)
      .addExcludedAttribute(14)
      .addExcludedAttribute(70)
      .addAllowedVendorType(745)
      .addAllowedVendorType(797)
      .addExcludedSensitiveCategory(36)
      .addExcludedSensitiveCategory(19)
      .addMatchingAdData(
        BidRequest.AdSlot.MatchingAdData.newBuilder()
          .addBillingId(22441369382L)
          .addBillingId(45062586958L)
          .setMinimumCpmMicros(9000000L)
          .build()
      )
      .setSlotVisibility(BidRequest.AdSlot.SlotVisibility.ABOVE_THE_FOLD)
      .addExcludedProductCategory(10112)
      .addExcludedProductCategory(10609)
      .setAdBlockKey(Long.parseUnsignedLong("5777127829"))
      .addPublisherSettingsListId(Long.parseUnsignedLong("8769865693206423209"))
      .setViewability(98)
      .setClickThroughRate(0.0004502071242313832F)
      .setRenderer(BidRequest.AdSlot.Renderer.GOOGLE)
      .addAllowedAdTypes(BidRequest.AdSlot.AllowedAdType.ALLOWED_AD_TYPE_BANNER)
      .setIsAmpPage(BidRequest.AdSlot.AmpPage.DIALECT_HTML)
      .setAmpAdRequirementType(BidRequest.AdSlot.AmpAdRequirementType.AMP_AD_NOT_ALLOWED)
      .setSessionDepth(1)
      .addApi(BidRequest.AdSlot.APIFramework.OMID_1)
      .addApi(BidRequest.AdSlot.APIFramework.MRAID_1)
      .setOmidpn("Google")
      .setOmidpv("afma-sdk-i-v8.4.0")
      .setCreativeEnforcementSettings(
        BidRequest.AdSlot.CreativeEnforcementSettings.newBuilder()
          .setPolicyEnforcement(BidRequest.AdSlot.CreativeEnforcementSettings.PolicyEnforcement.POLICY_ENFORCEMENT_NETWORK_AND_PLATFORM_POLICY)
          .setPublisherBlocksEnforcement(BidRequest.AdSlot.CreativeEnforcementSettings.PublisherBlocksEnforcement.PUBLISHER_BLOCKS_ENFORCEMENT_APPLIES)
          .setIsDefault(true)
          .build()
      )
      .build();

    BidRequest.Mobile mobile = BidRequest.Mobile.newBuilder()
      .setAppId("578848334")
      .setIsApp(true)
      .setEncryptedAdvertisingId(ByteString.copyFrom(ByteStringUtil.getTestBytes(16)))
      .setAppName("Test App")
      .setAdvertisingId(ByteString.copyFrom(ByteStringUtil.getTestBytes(16)))
      .setSkadn(
        BidRequest.Mobile.SKAdNetworkRequest.newBuilder()
          .setVersion("2.0")
          .setSourceapp("578848334")
          .addSkadnetids("OfT60030")
          .addSkadnetids("TN9F00n3")
          .build()
      )
      .build();

    BidRequest.Device device = BidRequest.Device.newBuilder()
      .setDeviceType(BidRequest.Device.DeviceType.HIGHEND_PHONE)
      .setPlatform("iphone")
      .setBrand("apple")
      .setModel("iphone")
      .setOsVersion(
        BidRequest.Device.OsVersion.newBuilder()
          .setMajor(14)
          .setMinor(2)
          .build()
      )
      .build();

    BidRequest.Geo geo = BidRequest.Geo.newBuilder()
      .setLat(35.68D)
      .setLon(139.65D)
      .setCountry("JPN")
      .setRegion("JP-13")
      .setAccuracy(386232)
      .build();

    BidRequest.UserAgent userAgent = BidRequest.UserAgent.newBuilder()
      .setPlatform(
        BidRequest.UserAgent.BrandVersion.newBuilder()
          .setBrand("iphone")
          .addVersion("14")
          .addVersion("2")
          .build()
      )
      .setMobile(true)
      .build();

    BidRequest.SupplyChain supplyChain = BidRequest.SupplyChain.newBuilder()
      .setComplete(true)
      .addNodes(
        BidRequest.SupplyChain.SupplyChainNode.newBuilder()
          .setAdvertisingSystemIdentifier("google.com")
          .setSellerIdentifier("pub-1111111111111111")
          .setHandlesPayment(true)
          .build()
      )
      .setVersion("1.0")
      .build();

    bidRequest = BidRequest.newBuilder()
      .setId(ByteString.copyFrom(ByteStringUtil.getTestBytes(16)))
      .setIp(ByteString.copyFrom(ByteStringUtil.getTestBytes(3)))
      .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 14_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148")
      .setUrl("https://www.google.com")
      .addDetectedLanguage("ja")
      .addAdslot(adSlot)
      .setIsTest(false)
      .setCookieVersion(Integer.parseUnsignedInt("1"))
      .setGoogleUserId("nr2J1uz7L35WK196M1dc0W3AsN7")
      .setMobile(mobile)
      .setCookieAgeSeconds(44064000)
      .setGeoCriteriaId(20636)
      .setSellerNetworkId(1)
      .setPublisherSettingsListId(Long.parseUnsignedLong("11504380065264872157"))
      .setPublisherType(BidRequest.PublisherType.PUBLISHER_OWNED_AND_OPERATED)
      .setPartnerId(Long.parseUnsignedLong("3592487169988961141"))
      .setDevice(device)
      .setPublisherCountry("JP")
      .setPublisherId("pub-1111111111111111")
      .setResponseDeadlineMs(300)
      .setGoogleQueryId("ANy-z9L3Nz-8J49Nc337x65b376133w02pu9Y6XX7h07317s6F9i09RLl50r226POnK0n880")
      .setAuctionType(BidRequest.AuctionType.FIRST_PRICE)
      .setGeo(geo)
      .setUserAgentData(userAgent)
      .setSupplyChain(supplyChain)
      .setFrequencyCappingScope(BidRequest.FrequencyCappingScope.FREQUENCY_CAPPING_SCOPE_DEVICE)
      .build();
  }

  @Test
  public void protobuf_to_binary_and_parseFrom_equals_테스트() throws Exception {
    byte[] originBytes = this.bidRequest.toByteArray();
    BidRequest targetBidRequest = BidRequest.parseFrom(originBytes);
    assertThat(targetBidRequest).isEqualTo(this.bidRequest);
  }

  @Test
  public void protobuf_object_to_binary_and_binary_to_object_with_binaryString_테스트() throws Exception {
    // given
    byte[] originBytes = this.bidRequest.toByteArray();

    // when
    String targetBytesString = BinaryStringUtil.byteArrayToBinaryString(originBytes);
    byte[] targetBytes = BinaryStringUtil.binaryStringToByteArray(targetBytesString);
    BidRequest targetBidRequest = BidRequest.parseFrom(targetBytes);

    // then
    assertThat(targetBidRequest).isEqualTo(this.bidRequest);
  }

  @Test
  public void byteArrayToBinaryString_binaryStringToByteArray_테스트() {
    // given
    byte[] originBytes = this.bidRequest.toByteArray();
    String originBinaryString = BinaryStringUtil.byteArrayToBinaryString(originBytes);

    // when
    byte[] targetBytes = BinaryStringUtil.binaryStringToByteArray(originBinaryString);

    // then
    assertThat(Arrays.equals(targetBytes, originBytes)).isEqualTo(true);
  }

  @Test
  public void json_to_protobuf_and_print_테스트() throws Exception{
    ClassPathResource resource = new ClassPathResource("sample-bid-request.json");
    Path path = Paths.get(resource.getURI());
    String jsonBidRequest = String.join("", Files.readAllLines(path));

    JsonFormat.Parser parser = JsonFormat.parser();
    BidRequest.Builder builder = BidRequest.newBuilder();

    parser.merge(jsonBidRequest, builder);
    BidRequest parsedBidRequest = builder.build();

    System.out.println(parsedBidRequest);
  }

  @Test
  public void protobuf_to_json_and_print_테스트() throws Exception {
    JsonFormat.Printer printer = JsonFormat.printer();
    System.out.println(printer.print(this.bidRequest));
  }

  @Test
  public void protobuf_to_json_and_json_to_protobuf_테스트() throws Exception {
    JsonFormat.Printer printer = JsonFormat.printer();
    JsonFormat.Parser parser = JsonFormat.parser();

    BidRequest.Builder builder = BidRequest.newBuilder();

    parser.merge(printer.print(this.bidRequest), builder);
    BidRequest parsedBidRequest = builder.build();

    assertThat(this.bidRequest).isEqualTo(parsedBidRequest);
    assertThat(this.bidRequest.toString()).isEqualTo(parsedBidRequest.toString());
  }
}
