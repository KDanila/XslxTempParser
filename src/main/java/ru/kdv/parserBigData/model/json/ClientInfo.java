package ru.kdv.parserBigData.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@JsonIgnoreProperties({"fio", "dob", "inn"})
@JsonPropertyOrder({
        "id",
        "territorialBank",
        "address",
        "phoneNumbers",
        "FIO",
        "DOB",
        "INN"
})
@SuppressWarnings({"checkstyle:AbbreviationAsWordInName", "checkstyle:MemberName"})
public class ClientInfo {
    String id;
    String territorialBank;
    @JsonProperty("FIO")
    String FIO;
    @JsonProperty("DOB")
    String DOB;
    @JsonProperty("INN")
    Long INN;
    Address address;
    List<PhoneNumber> phoneNumbers;
}
