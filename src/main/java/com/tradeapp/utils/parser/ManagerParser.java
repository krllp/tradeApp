package com.tradeapp.utils.parser;

import com.tradeapp.entities.ManagerEntity;
import com.tradeapp.storage.Storage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ManagerParser implements Parser {

    public static final ManagerParser INSTANCE = new ManagerParser();

    private ManagerParser() {
    }

    private static List<ManagerEntity> fullManagersList = new ArrayList<>();
    private long managerAndTeamID = 1;

    /**
     * Метод парсит данные менеджера из Json-объекта и
     * передает готовый спиок всех менеджеров в хранилище Storage
     * @param jsonObject Json-объект, содержащий всех менеджеров
     */
    @Override
    public void parse(JSONObject jsonObject) {
        JSONArray jsonTeamList = (JSONArray) jsonObject.get(JsonKeys.TEAMS);

        for(Object o : jsonTeamList) {
            JSONObject jsonTeam = (JSONObject) o;
            JSONObject jsonManager = getJsonManager((JSONArray) jsonTeam.get(JsonKeys.MANAGER));
            getManager(managerAndTeamID, managerAndTeamID, jsonManager );

            managerAndTeamID++;
        }

        Storage.INSTANCE.setManagers(fullManagersList);
    }

    /**
     * Метод достает первый элемент менеджера из массива
     * @param jsonManager json массив с данными менеджера
     * @return возвращает Json-объект единственного менеджера
     */
    private JSONObject getJsonManager(JSONArray jsonManager) {
        return (JSONObject) jsonManager.get(0);
    }

    /**
     * Метод инициализирует сущность менеджера
     * @param managerID идентификатор менеджера
     * @param jsonManager json объект с данными менеджера
     * @param teamID идентификатор команды
     */
    private void getManager(long managerID, long teamID, JSONObject jsonManager) {
        ManagerEntity managerEntity = new ManagerEntity();

        managerEntity.setID(managerID);
        managerEntity.setName((String) jsonManager.get(JsonKeys.MANAGER_NAME));
        managerEntity.setLogin((String) jsonManager.get(JsonKeys.MANAGER_LOGIN));
        managerEntity.setPassword((String) jsonManager.get(JsonKeys.MANAGER_PASS));
        managerEntity.setTeamID(teamID);

        fullManagersList.add(managerEntity);
    }

    private class JsonKeys {
        private static final String TEAMS = "teams";
        private static final String MANAGER = "manager";

        private static final String MANAGER_NAME = "name";
        private static final String MANAGER_LOGIN = "login";
        private static final String MANAGER_PASS = "pass";
    }
}
