package ru.kdv.parserBigData.model.json;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonPropertyOrder({
        "type",
        "number"
})
public class PhoneNumber {
    String type;
    String number;
}
