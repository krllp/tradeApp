package com.tradeapp.utils.parser;

import com.tradeapp.entities.TeamEntity;
import com.tradeapp.storage.Storage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TeamParser implements Parser {

    public static final TeamParser INSTANCE = new TeamParser();

    private TeamParser() {
    }

    private static List<TeamEntity> fullTeamsList = new ArrayList<>();
    private long teamID = 1;

    /**
     * Метод парсит название команды из Json-объекта и
     * передает готовый спиок всех команд в хранилище Storage
     * @param jsonObject Json-объект, содержащий все команды
     */
    @Override
    public void parse(JSONObject jsonObject) {
        JSONArray jsonTeamList = (JSONArray) jsonObject.get(JsonKeys.TEAMS);

        for (Object o : jsonTeamList) {
            JSONObject jsonTeam = (JSONObject) o;
            getTeam(teamID++, (String) jsonTeam.get(JsonKeys.TEAM_NAME));
        }

        Storage.INSTANCE.setTeams(fullTeamsList);
    }

    /**
     * Метод инициализирует сущность команды
     * @param ID идентификатор команды
     * @param name название команды
     */
    private void getTeam(long ID, String name) {
        TeamEntity teamEntity = new TeamEntity();

        teamEntity.setID(ID);
        teamEntity.setName(name);

        fullTeamsList.add(teamEntity);
    }

    private class JsonKeys {
        private static final String TEAMS = "teams";

        private static final String TEAM_NAME = "name";
    }
}
