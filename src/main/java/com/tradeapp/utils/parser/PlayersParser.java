package com.tradeapp.utils.parser;

import com.tradeapp.entities.PlayerEntity;
import com.tradeapp.storage.Storage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PlayersParser implements Parser {

    private static List<PlayerEntity> fullPlayersList = new ArrayList<>();
    private long playerID = 1;

    /**
     * Метод парсит данные игроков из Json-объекта и
     * передает готовый спиок всех игроков в хранилище Storage
     * @param jsonObject Json-объект, содержащий всех игроков
     */
    @Override
    public void parse(JSONObject jsonObject) {
        JSONArray jsonArray = (JSONArray) jsonObject.get(JsonKeys.TEAMS);

        long teamID = 1;

        for (Object o : jsonArray) {
            JSONObject jsonObjectPlayers = (JSONObject) o;
            getPlayers((JSONArray) jsonObjectPlayers.get(JsonKeys.PLAYERS), teamID++);
        }

        Storage.INSTANCE.setPlayers(fullPlayersList);
    }

    /**
     * Метод инициализирует сущность игроков
     * @param jsonArray json массив с данными игроков
     * @param teamID идентификатор команды
     */
    private void getPlayers(JSONArray jsonArray, long teamID) {
        for(Object o : jsonArray) {
            PlayerEntity playerEntity = new PlayerEntity();
            JSONObject player = (JSONObject) o;

            playerEntity.setId(playerID++);
            playerEntity.setName((String) player.get(JsonKeys.PLAYER_NAME));
            playerEntity.setSalary(Integer.parseInt((String ) player.get(JsonKeys.PLAYER_SALARY)));
            playerEntity.setTeamID(teamID);

            fullPlayersList.add(playerEntity);
        }
    }

    private class JsonKeys {
        private static final String TEAMS = "teams";
        private static final String PLAYERS = "players";

        private static final String PLAYER_NAME = "name";
        private static final String PLAYER_SALARY = "salary";
    }
}
