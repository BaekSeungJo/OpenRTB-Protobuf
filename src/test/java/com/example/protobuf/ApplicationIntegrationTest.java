package com.example.protobuf;

import com.example.protobuf.model.google.BidRequest;
import com.google.protobuf.util.JsonFormat;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DirtiesContext
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationIntegrationTest {

  @Autowired
  private RestTemplate restTemplate;

  @LocalServerPort
  private int port;

  @Test
  public void whenUsingRestTemplate_thenSucceed() {
    ResponseEntity<BidRequest> bidRequest = restTemplate.getForEntity(getUrl(), BidRequest.class);
    assertResponse(bidRequest.toString());
  }

  @Test
  public void whenUsingHttpClientJson_thenSucceed() throws IOException {
    InputStream jsonResponseStream = executeHttpRequest(getUrl(), MediaType.APPLICATION_JSON);
    String jsonOutput = convertStreamToString(jsonResponseStream);
    assertResponse(jsonOutput);
  }

  @Test
  public void whenUsingHttpClientProtobuf_thenSucceed() throws IOException {
    InputStream responseStream = executeHttpRequest(getUrl(), ProtobufHttpMessageConverter.PROTOBUF);
    String jsonOutput = convertProtobufMessageStreamToJsonString(responseStream);
    assertResponse(jsonOutput);
  }

  private InputStream executeHttpRequest(String url, MediaType mediaType) throws IOException {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpGet request = new HttpGet(url);
    request.setHeader(HttpHeaders.ACCEPT, mediaType.toString());

    HttpResponse httpResponse = httpClient.execute(request);
    return httpResponse.getEntity().getContent();
  }

  /**
   * https://medium.com/the-fancy-dev/test-e95729cae30c 참조
   *
   * @param protobufStream
   * @return
   * @throws IOException
   */
  private String convertProtobufMessageStreamToJsonString(InputStream protobufStream) throws IOException {
    BidRequest bidRequest = BidRequest.parseFrom(protobufStream);
    return JsonFormat.printer().print(bidRequest);
  }

  private String convertStreamToString(InputStream inputStream) throws IOException {
    return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
  }

  private void assertResponse(String response) {
    System.out.println(response);

//    assertThat(response).contains("");
//    assertThat(response).contains("");
//    assertThat(response).contains("");
//    assertThat(response).contains("");
//    assertThat(response).contains("");
//    assertThat(response).contains("");
//    assertThat(response).contains("");
//    assertThat(response).contains("");
//    assertThat(response).contains("");
  }

  private String getUrl() {
    return "http://localhost:" + port + "/bidRequest/0";
  }
}
