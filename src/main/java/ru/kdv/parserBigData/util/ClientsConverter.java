package ru.kdv.parserBigData.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.kdv.parserBigData.model.json.Clients;

import java.util.Objects;
import java.util.Optional;

import static ru.kdv.parserBigData.constant.ClientConverterConstant.EMPTY_CLIENTS;

public class ClientsConverter {
    public static String convertToJson(Clients clients) {
        if (Objects.isNull(clients) || clients.getClients().size() == 0) {
            return EMPTY_CLIENTS;
        }
        filterNullClients(clients);
        return createJsonString(clients);
    }

    private static String createJsonString(Clients clients) {
        ObjectMapper objectMapper = new ObjectMapper();
        Optional<String> toReturn = Optional.empty();
        try {
            toReturn = Optional.ofNullable(objectMapper.writeValueAsString(clients));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return toReturn.orElse(EMPTY_CLIENTS);
    }

    private static void filterNullClients(Clients clients) {
        clients.getClients()
                .removeIf(Objects::isNull);
    }
}
