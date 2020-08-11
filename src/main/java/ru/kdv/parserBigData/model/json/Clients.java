package ru.kdv.parserBigData.model.json;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Clients {
    List<Client> clients;
}