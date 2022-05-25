package com.example.protobuf.repository;

import com.example.protobuf.model.google.BidRequest;
import com.example.protobuf.util.ByteStringUtil;
import com.google.protobuf.ByteString;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BidRequestRepository {
  private List<BidRequest> bidRequests = new ArrayList<>();

  public BidRequestRepository() {
    readBidRequestData();
  }

  public BidRequest getBidRequest(int index) {
    return bidRequests.get(index);
  }

  public List<BidRequest> getBidRequests() {
    return bidRequests;
  }

  public void readBidRequestData() {
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

    BidRequest bidRequest = BidRequest.newBuilder()
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

    this.bidRequests.add(bidRequest);
  }
}
