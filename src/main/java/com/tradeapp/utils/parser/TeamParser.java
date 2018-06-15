package com.tradeapp.utils.parser;

import com.tradeapp.entities.TeamEntity;
import com.tradeapp.storage.Storage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TeamParser implements Parser {

    private static List<TeamEntity> fullTeamsList = new ArrayList<>();

    /**
     * Метод парсит название команды из Json-объекта и
     * передает готовый спиок всех команд в хранилище Storage
     * @param jsonObject Json-объект, содержащий все команды
     */
    @Override
    public void parse(JSONObject jsonObject) {
        JSONArray jsonArray = (JSONArray) jsonObject.get(JsonKeys.TEAMS);

        long teamID = 1;

        for (Object o : jsonArray) {
            JSONObject jsonObjectTeam = (JSONObject) o;
            getTeam(teamID++, (String) jsonObjectTeam.get(JsonKeys.TEAM_NAME));
        }

        Storage.INSTANCE.setTeams(fullTeamsList);
    }

    /**
     * Метод инициализирует сущность команды
     * @param id идентификатор команды
     * @param name название команды
     */
    private void getTeam(long id, String name) {
        TeamEntity teamEntity = new TeamEntity();

        teamEntity.setId(id);
        teamEntity.setName(name);

        fullTeamsList.add(teamEntity);
    }

    private class JsonKeys {
        private static final String TEAMS = "teams";

        private static final String TEAM_NAME = "name";
    }
}
