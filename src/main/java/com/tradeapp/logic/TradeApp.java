package com.tradeapp.logic;

import com.tradeapp.config.AppConfig;
import com.tradeapp.utils.parser.AppConfigParser;

public class TradeApp {

    private static final String CONFIG_FILENAME = "config.json";

    private AppConfig cfg;

    public TradeApp() {
        cfg = AppConfigParser.INSTANCE.parse(CONFIG_FILENAME);
    }

    public void start() {

    }
}
