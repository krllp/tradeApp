package com.tradeapp.logic;

import com.tradeapp.config.AppConfig;
import com.tradeapp.entities.TeamEntity;
import com.tradeapp.utils.parser.AppConfigParser;
import com.tradeapp.utils.parser.TeamsParser;

import java.util.List;

public class TradeApp {

    private static final String CONFIG_FILENAME = "config.json";

    private AppConfig cfg;
    private List<TeamEntity> teamsList;

    public TradeApp() {
        cfg = AppConfigParser.INSTANCE.parse(CONFIG_FILENAME);
        teamsList = TeamsParser.INSTANCE.parse(cfg.getPathToFile());
    }

    public void start() {

    }
}
