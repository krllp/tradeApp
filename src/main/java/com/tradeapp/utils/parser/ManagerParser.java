package com.tradeapp.utils.parser;

import com.tradeapp.entities.ManagerEntity;
import com.tradeapp.storage.Storage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ManagerParser implements Parser {

    private static List<ManagerEntity> fullManagersList = new ArrayList<>();

    /**
     * Метод парсит данные менеджера из Json-объекта и
     * передает готовый спиок всех менеджеров в хранилище Storage
     * @param jsonObject Json-объект, содержащий всех менеджеров
     */
    @Override
    public void parse(JSONObject jsonObject) {
        JSONArray jsonArray = (JSONArray) jsonObject.get(JsonKeys.TEAMS);

        long managerAndTeamID = 1;

        for(Object o : jsonArray) {
            JSONObject jsonObjectManager = (JSONObject) o;
            getManager(managerAndTeamID, (JSONArray) jsonObjectManager.get(JsonKeys.MANAGER), managerAndTeamID);

            managerAndTeamID++;
        }

        Storage.INSTANCE.setManagers(fullManagersList);
    }

    /**
     * Метод инициализирует сущность менеджера
     * @param managerID идентификатор менеджера
     * @param jsonArray json массив с данными менеджера
     * @param teamID идентификатор команды
     */
    private void getManager(long managerID, JSONArray jsonArray, long teamID) {
        for(Object o : jsonArray) {
            ManagerEntity managerEntity = new ManagerEntity();
            JSONObject manager = (JSONObject) o;

            managerEntity.setId(managerID);
            managerEntity.setName((String) manager.get(JsonKeys.MANAGER_NAME));
            managerEntity.setLogin((String) manager.get(JsonKeys.MANAGER_LOGIN));
            managerEntity.setPassword((String) manager.get(JsonKeys.MANAGER_PASS));
            managerEntity.setTeamID(teamID);

            fullManagersList.add(managerEntity);
        }
    }

    private class JsonKeys {
        private static final String TEAMS = "teams";
        private static final String MANAGER = "manager";

        private static final String MANAGER_NAME = "name";
        private static final String MANAGER_LOGIN = "login";
        private static final String MANAGER_PASS = "pass";
    }
}
