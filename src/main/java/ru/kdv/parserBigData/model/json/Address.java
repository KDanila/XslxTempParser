package ru.kdv.parserBigData.model.json;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonPropertyOrder({
        "registrationAddress",
        "actualAddress"
})
public class Address {
    String registrationAddress;
    String actualAddress;
}
