package ru.kdv.parserBigData.model.json;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonPropertyOrder({
        "id",
        "number",
        "issueDate",
        "expirationDate",
        "type",
        "member",
        "stage",
        "maturityStartDate",
        "maturityEndDate",
        "amount",
        "delayDate",
        "countDaysPast",
        "lastPayment"
})
public class ContractInfo {
    String id;
    String number;
    String issueDate;
    String expirationDate;
    String type;
    String member;
    String stage;
    String maturityStartDate;
    String maturityEndDate;
    Amount amount;
    String delayDate;
    Integer countDaysPast;
    LastPayment lastPayment;
}