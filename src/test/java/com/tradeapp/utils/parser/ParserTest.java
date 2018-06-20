package com.tradeapp.utils.parser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ParserTest {

    private String PATH_TO_JSON = "src/test/resources/teams.test.json";

    JSONObject getTestJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(new FileReader(PATH_TO_JSON));
    }
}
