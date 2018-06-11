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

public class EntitiesParser {

    public static final EntitiesParser INSTANCE = new EntitiesParser();

    private EntitiesParser() {
    }

    public List<TeamEntity> parse(String pathToFile) {
        List<TeamEntity> teamsList = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(pathToFile));
            JSONArray jsonArray = (JSONArray) jsonObject.get(JsonKeys.TEAMS);

            for(Object o : jsonArray) {
                JSONObject teamObject = (JSONObject) o;

                ManagerEntity manager = parseManager((JSONArray) teamObject.get(JsonKeys.TEAM_MANAGER));
                List<PlayerEntity> players = parsePlayers((JSONArray) teamObject.get(JsonKeys.TEAM_PLAYERS));
                TeamEntity team = parseTeam((String) teamObject.get(JsonKeys.TEAM_NAME), manager, players);

                teamsList.add(team);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return teamsList;
    }

    /**
     *
     * @param name Название команды
     * @param manager Сущность менеджера команды
     * @param players Список сущностей игроков команды
     * @return Сущность команды
     */
    private TeamEntity parseTeam(String name, ManagerEntity manager, List<PlayerEntity> players) {
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setName(name);
        teamEntity.setManager(manager);
        teamEntity.setPlayers(players);

        return teamEntity;
    }

    /**
     *
     * @param playersArray спарсенный список игроков
     * @return Список сущностей игроков команды
     */
    private List<PlayerEntity> parsePlayers(JSONArray playersArray) {
        List<PlayerEntity> playerEntityList = new ArrayList<>();

        for(Object o : playersArray) {
            JSONObject player = (JSONObject) o;
            PlayerEntity playerEntity = new PlayerEntity();
            playerEntity.setName((String) player.get(JsonKeys.PLAYER_NAME));
            playerEntity.setSalary(Integer.parseInt((String ) player.get(JsonKeys.PLAYER_SALARY)));
            playerEntityList.add(playerEntity);
        }

        return playerEntityList;
    }

    /**
     *
     * @param managerArray спарсенные данные менеджера
     * @return Сущность менеджера команды
     */
    private ManagerEntity parseManager(JSONArray managerArray) {
        ManagerEntity managerEntity = new ManagerEntity();
        for(Object o : managerArray) {
            JSONObject manager = (JSONObject) o;
            managerEntity.setName((String) manager.get(JsonKeys.MANAGER_NAME));
            managerEntity.setLogin((String) manager.get(JsonKeys.MANAGER_LOGIN));
            managerEntity.setPassword((String) manager.get(JsonKeys.MANAGER_PASS));
        }

        return managerEntity;
    }

    private class JsonKeys {
        private static final String TEAMS = "teams";

        private static final String TEAM_NAME = "name";
        private static final String TEAM_MANAGER = "manager";
        private static final String TEAM_PLAYERS = "players";

        private static final String MANAGER_NAME = "name";
        private static final String MANAGER_LOGIN = "login";
        private static final String MANAGER_PASS = "pass";

        private static final String PLAYER_NAME = "name";
        private static final String PLAYER_SALARY = "salary";
    }
}
