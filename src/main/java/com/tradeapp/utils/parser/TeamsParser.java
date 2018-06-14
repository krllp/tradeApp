package com.tradeapp.utils.parser;

import com.tradeapp.entities.ManagerEntity;
import com.tradeapp.entities.PlayerEntity;
import com.tradeapp.entities.TeamEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeamsParser {

    public static final TeamsParser INSTANCE = new TeamsParser();

    private TeamsParser() {
    }

    public List<TeamEntity> parse(String pathToFile) {
        List<TeamEntity> teamsList = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(pathToFile));
            JSONArray jsonArray = (JSONArray) jsonObject.get(JsonKeys.TEAMS);

            for(Object o : jsonArray) {
                JSONObject teamObject = (JSONObject) o;

                ManagerEntity manager = new ManagerParser().parse((JSONArray) teamObject.get(JsonKeys.TEAM_MANAGER));
                List<PlayerEntity> players = new PlayersParser().parse((JSONArray) teamObject.get(JsonKeys.TEAM_PLAYERS));
                TeamEntity team = getTeamEntity((String) teamObject.get(JsonKeys.TEAM_NAME), manager, players);

                teamsList.add(team);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return teamsList;
    }

    /**
     * Метод получения сущности команды
     * @param name Название команды
     * @param manager Сущность менеджера команды
     * @param players Список сущностей игроков команды
     * @return Сущность команды
     */
    public TeamEntity getTeamEntity(String name, ManagerEntity manager, List<PlayerEntity> players) {
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setName(name);
        teamEntity.setManager(manager);
        teamEntity.setPlayers(players);

        return teamEntity;
    }

    private class JsonKeys {
        private static final String TEAMS = "teams";

        private static final String TEAM_NAME = "name";
        private static final String TEAM_MANAGER = "manager";
        private static final String TEAM_PLAYERS = "players";
    }
}
