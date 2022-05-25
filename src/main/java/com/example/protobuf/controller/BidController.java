package com.example.protobuf.controller;

import com.example.protobuf.model.google.BidRequest;
import com.example.protobuf.repository.BidRequestRepository;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BidController {
  private final BidRequestRepository bidRequestRepository;

  public BidController(BidRequestRepository bidRequestRepository) {
    this.bidRequestRepository = bidRequestRepository;
  }

  @GetMapping("/bidRequest/{index}")
  String getBidRequestJson(@PathVariable int index) throws InvalidProtocolBufferException {
    return JsonFormat.printer().print(bidRequestRepository.getBidRequest(index));
  }

  @GetMapping(value = "/bidRequest/{index}", produces = "application/x-protobuf")
  BidRequest getBidRequestProtobuf(@PathVariable int index) {
    return this.bidRequestRepository.getBidRequest(index);
  }
}
