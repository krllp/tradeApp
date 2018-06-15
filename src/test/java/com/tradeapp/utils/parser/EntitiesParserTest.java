package com.tradeapp.utils.parser;

import com.tradeapp.entities.ManagerEntity;
import com.tradeapp.entities.PlayerEntity;
import com.tradeapp.entities.TeamEntity;
import com.tradeapp.storage.Storage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EntitiesParserTest {

    private static final String FILE_NAME = "teams.test.json";
    private static final String TEAM_NAME = "testNameTeam";
    private static final String MANAGER_NAME = "testNameManager";
    private static final String MANAGER_LOGIN = "testLogin";
    private static final String MANAGER_PASSWORD = "testPass";
    private static final String PLAYER_NAME = "testNamePlayer";
    private static final int PLAYER_SALARY = 100;
    private static final long PLAYER_TEAM_ID = 1;

    private String teamName;

    private String managerName;
    private String managerLogin;
    private String managerPass;

    private long playerTeamID;
    private String playerName;
    private int playerSalary;

    @Before
    public void parseEntitiesForTest() {
        EntitiesParser.INSTANCE.parse(FILE_NAME);

        for (TeamEntity teams : Storage.INSTANCE.getTeams()) {
            teamName = teams.getName();
        }

        for (ManagerEntity managers : Storage.INSTANCE.getManagers()) {
            managerName = managers.getName();
            managerLogin = managers.getLogin();
            managerPass = managers.getPassword();
        }

        for (PlayerEntity players : Storage.INSTANCE.getPlayers()) {
            playerTeamID = players.getTeamID();
            playerName = players.getName();
            playerSalary = players.getSalary();
        }
    }

    @Test
    public void teamNameShouldBeEqual() {
        Assert.assertEquals(TEAM_NAME, teamName);
    }

    @Test
    public void managerNameShouldBeEqual() {
        Assert.assertEquals(MANAGER_NAME, managerName);
    }

    @Test
    public void managerLoginShouldBeEqual() {
        Assert.assertEquals(MANAGER_LOGIN, managerLogin);
    }

    @Test
    public void managerPasswordShouldBeEqual() {
        Assert.assertEquals(MANAGER_PASSWORD, managerPass);
    }

    @Test
    public void playerNameShouldBeEqual() {
        Assert.assertEquals(PLAYER_NAME, playerName);
    }

    @Test
    public void playerSalaryShouldBeEqual() {
        Assert.assertEquals(PLAYER_SALARY, playerSalary);
    }

    @Test
    public void playerTeamIdShouldBeEqualTeamId() {
        Assert.assertEquals(PLAYER_TEAM_ID, playerTeamID);
    }
}
