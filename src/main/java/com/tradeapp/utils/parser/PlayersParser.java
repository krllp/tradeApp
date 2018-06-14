package com.tradeapp.utils.parser;

import com.tradeapp.entities.PlayerEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PlayersParser implements EntitiesParserInterface {

    /**
     *  Метод получения игроков из json-объекта
     * @param playersArray спарсенный список игроков
     * @return Список сущностей игроков команды
     */
    @Override
    public List<PlayerEntity> parse(JSONArray playersArray) {
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

    private class JsonKeys {
        private static final String PLAYER_NAME = "name";
        private static final String PLAYER_SALARY = "salary";
    }
}
