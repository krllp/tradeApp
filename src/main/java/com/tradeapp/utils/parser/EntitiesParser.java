package com.tradeapp.utils.parser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EntitiesParser {

    public static final EntitiesParser INSTANCE = new EntitiesParser();

    private final List<Parser> parsers;

    private EntitiesParser() {
        parsers = Arrays.asList(
                TeamParser.INSTANCE,
                ManagerParser.INSTANCE,
                PlayersParser.INSTANCE
        );
    }

    /**
     * Метод парсит все сущности команд, менеджеров и игроков
     * @param pathToFile путь до Json-файла с составами команд
     */
    public void parse(String pathToFile) {
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(pathToFile));

            for(Parser parser : parsers)
                parser.parse(jsonObject);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
