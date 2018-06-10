package com.tradeapp.utils.parser;

import com.tradeapp.config.AppConfig;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class AppConfigParser {

    public static final AppConfigParser INSTANCE = new AppConfigParser();

    private AppConfigParser() {
    }

    public AppConfig parse(String fileName) {
        AppConfig cfg = new AppConfig();
        JSONParser parser = new JSONParser();
        try {
            JSONObject jObj = (JSONObject) parser.parse(new FileReader(fileName));
            cfg.setPathToFile((String) jObj.get(JsonKeys.PATH_TO_FILE));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return cfg;
    }

    private class JsonKeys {
        private static final String PATH_TO_FILE = "pathToFile";
    }
}
