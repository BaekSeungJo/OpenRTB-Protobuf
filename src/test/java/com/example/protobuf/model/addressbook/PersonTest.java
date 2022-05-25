package com.example.protobuf.model.addressbook;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PersonTest {

  @Test
  public void Person_생성_테스트() {
    // given
    int id = 1;
    String name = "Baek SeungJo";
    String phoneNumber = "1234-5678";
    Person.PhoneType phoneType = Person.PhoneType.HOME;

    // when
    Person person = Person.newBuilder()
      .setId(id)
      .setName("Baek SeungJo")
      .addPhones(
        Person.PhoneNumber.newBuilder()
          .setNumber("1234-5678")
          .setType(phoneType))
      .build();

    // then
    assertThat(person.getId()).isEqualTo(id);
    assertThat(person.getName()).isEqualTo(name);
    assertThat(person.getPhonesCount()).isEqualTo(1);
    assertThat(person.getPhones(0).getNumber()).isEqualTo(phoneNumber);
    assertThat(person.getPhones(0).getType()).isEqualTo(phoneType);
  }

  @Test
  public void Person_required_필드_설정_검증_테스트() {
    // given
    String name = "Baek SeungJo";

    // when
    Person person = Person.newBuilder()
      .setName("Baek SeungJo")
      .build();

    // then
    assertThat(person.isInitialized()).isEqualTo(true);
  }
}
