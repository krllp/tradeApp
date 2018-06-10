package com.trade.logic;

import com.trade.config.AppConfig;
import com.trade.utils.parser.AppConfigParser;

public class TradeApp {

    private static final String CONFIG_FILENAME = "config.json";

    private AppConfig cfg;

    public TradeApp() {
        cfg = AppConfigParser.INSTANCE.parse(CONFIG_FILENAME);
    }

    public void start() {

    }
}
