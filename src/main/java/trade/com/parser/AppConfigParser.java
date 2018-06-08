package trade.com.parser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import trade.com.config.AppConfig;

import java.io.FileReader;
import java.io.IOException;

public class AppConfigParser {

    public AppConfig parse(String path) {
        AppConfig cfg = new AppConfig();
        JSONParser parser = new JSONParser();
        try {
            JSONObject jObj = (JSONObject) parser.parse(new FileReader(path));
            cfg.setPathToFile((String) jObj.get(AppConfig.PATH_TO_FILE));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return cfg;
    }
}
