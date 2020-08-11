package ru.kdv.parserBigData.model.json;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
@JsonPropertyOrder({
        "date",
        "amount"
})
public class LastPayment {
    String date;
    BigDecimal amount;
}
