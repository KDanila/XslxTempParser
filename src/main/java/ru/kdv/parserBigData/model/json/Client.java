package ru.kdv.parserBigData.model.json;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
@JsonPropertyOrder({
        "inclusionDebtDate",
        "completionDate",
        "interestRate",
        "clientInfo",
        "contractInfo"
})
public class Client {
    String inclusionDebtDate;
    String completionDate;
    BigDecimal interestRate;
    ClientInfo clientInfo;
    ContractInfo contractInfo;
}
