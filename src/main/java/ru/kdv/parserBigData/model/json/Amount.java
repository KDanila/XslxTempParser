package ru.kdv.parserBigData.model.json;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
@JsonPropertyOrder({
        "contractAmount",
        "urgentDebt",
        "overdue",
        "urgentInterest",
        "overdueInterest",
        "fines",
        "overdueForCA",
        "nationalTax"
})
@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public class Amount {
    BigDecimal contractAmount;
    BigDecimal urgentDebt;
    BigDecimal overdue;
    BigDecimal urgentInterest;
    BigDecimal overdueInterest;
    BigDecimal fines;
    BigDecimal overdueForCA;
    BigDecimal nationalTax;
}