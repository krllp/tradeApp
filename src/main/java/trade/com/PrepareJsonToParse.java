package trade.com;

import trade.com.config.AppConfig;
import trade.com.parser.AppConfigParser;

public class PrepareJsonToParse {

    private static final String CONFIG_FILENAME = "config.json";

    AppConfigParser appCfgParser = new AppConfigParser();

    private AppConfig appConfig;

    void parseDat() {
        parseConfig();
    }

    private void parseConfig() {
        appConfig = appCfgParser.parse(CONFIG_FILENAME);
    }
}
