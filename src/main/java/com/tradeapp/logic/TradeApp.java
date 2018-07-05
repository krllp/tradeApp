package com.tradeapp.logic;

import com.tradeapp.config.AppConfig;
import com.tradeapp.transition.State;
import com.tradeapp.transition.Transition;
import com.tradeapp.utils.parser.AppConfigParser;
import com.tradeapp.utils.parser.EntitiesParser;

import java.util.Collections;

public class TradeApp {

    private static final String CONFIG_FILENAME = "config.json";

    private AppConfig cfg;

    public TradeApp() {
        cfg = AppConfigParser.INSTANCE.parse(CONFIG_FILENAME);
        EntitiesParser.INSTANCE.parse(cfg.getPathToFile());
    }

    public void start() {
        Transition.INSTANCE.go(State.LOGIN, Collections.emptyMap());
    }
}
