package com.tradeapp.utils.parser;

import com.tradeapp.storage.Storage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EntitiesParserTest {

    private static final String FILE_NAME = "teams.test.json";

    private static final String FIRST_TEAM_NAME = "testNameTeam1";
    private static final long FIRST_MANAGER_TEAM_ID = 1;
    private static final String FIRST_MANAGER_NAME = "testNameManager1";
    private static final String FIRST_MANAGER_LOGIN = "testLogin1";
    private static final String FIRST_MANAGER_PASSWORD = "testPass1";
    private static final String FIRST_PLAYER_NAME = "testNamePlayer1";
    private static final int FIRST_PLAYER_SALARY = 100;
    private static final long FIRST_PLAYER_TEAM_ID = 1;

    private static final String THIRD_TEAM_NAME = "testNameTeam3";
    private static final long THIRD_MANAGER_TEAM_ID = 3;
    private static final String THIRD_MANAGER_NAME = "testNameManager3";
    private static final String THIRD_MANAGER_LOGIN = "testLogin3";
    private static final String THIRD_MANAGER_PASSWORD = "testPass3";
    private static final String SEVENTH_PLAYER_NAME = "testNamePlayer7";
    private static final int SEVENTH_PLAYER_SALARY = 700;
    private static final long SEVENTH_PLAYER_TEAM_ID = 3;

    private static final long FIFTH_PLAYER_TEAM_ID = 2;

    @Before
    public void parseEntities() {
        EntitiesParser.INSTANCE.parse(FILE_NAME);
    }

    @Test
    public void firstTeamNameShouldBeEqual() {
        String teamName = Storage.INSTANCE.getTeams().get(0).getName();
        Assert.assertEquals(FIRST_TEAM_NAME, teamName);
    }

    @Test
    public void firstManagerNameShouldBeEqual() {
        String managerName = Storage.INSTANCE.getManagers().get(0).getName();
        Assert.assertEquals(FIRST_MANAGER_NAME, managerName);
    }

    @Test
    public void firstManagerLoginShouldBeEqual() {
        String managerLogin = Storage.INSTANCE.getManagers().get(0).getLogin();
        Assert.assertEquals(FIRST_MANAGER_LOGIN, managerLogin);
    }

    @Test
    public void firstManagerPasswordShouldBeEqual() {
        String managerPass = Storage.INSTANCE.getManagers().get(0).getPassword();
        Assert.assertEquals(FIRST_MANAGER_PASSWORD, managerPass);
    }

    @Test
    public void firstPlayerNameShouldBeEqual() {
        String playerName = Storage.INSTANCE.getPlayers().get(0).getName();
        Assert.assertEquals(FIRST_PLAYER_NAME, playerName);
    }

    @Test
    public void firstPlayerSalaryShouldBeEqual() {
        int playerSalary = Storage.INSTANCE.getPlayers().get(0).getSalary();
        Assert.assertEquals(FIRST_PLAYER_SALARY, playerSalary);
    }

    @Test
    public void firstPlayerTeamIdShouldBeEqualTeamId() {
        long playerTeamID = Storage.INSTANCE.getPlayers().get(0).getTeamID();
        Assert.assertEquals(FIRST_PLAYER_TEAM_ID, playerTeamID);
    }

    @Test
    public void firstManagerTeamIDShouldBeEqualTeamID() {
        long managerTeamID = Storage.INSTANCE.getManagers().get(0).getTeamID();
        Assert.assertEquals(FIRST_MANAGER_TEAM_ID, managerTeamID);
    }

    @Test
    public void thirdTeamNameShouldBeEqual() {
        String teamName = Storage.INSTANCE.getTeams().get(2).getName();
        Assert.assertEquals(THIRD_TEAM_NAME, teamName);
    }

    @Test
    public void thirdManagerTeamIDShouldBeEqualTeamID() {
        long managerTeamID = Storage.INSTANCE.getManagers().get(2).getTeamID();
        Assert.assertEquals(THIRD_MANAGER_TEAM_ID, managerTeamID);
    }

    @Test
    public void thirdManagerNameShouldBeEqual() {
        String managerName = Storage.INSTANCE.getManagers().get(2).getName();
        Assert.assertEquals(THIRD_MANAGER_NAME, managerName);
    }

    @Test
    public void thirdManagerLoginShouldBeEqual() {
        String managerLogin = Storage.INSTANCE.getManagers().get(2).getLogin();
        Assert.assertEquals(THIRD_MANAGER_LOGIN, managerLogin);
    }

    @Test
    public void thirdManagerPasswordShouldBeEqual() {
        String managerPass = Storage.INSTANCE.getManagers().get(2).getPassword();
        Assert.assertEquals(THIRD_MANAGER_PASSWORD, managerPass);
    }

    @Test
    public void seventhPlayerNameShouldBeEqual() {
        String playerName = Storage.INSTANCE.getPlayers().get(6).getName();
        Assert.assertEquals(SEVENTH_PLAYER_NAME, playerName);
    }

    @Test
    public void seventhPlayerSalaryShouldBeEqual() {
        int playerSalary = Storage.INSTANCE.getPlayers().get(6).getSalary();
        Assert.assertEquals(SEVENTH_PLAYER_SALARY, playerSalary);
    }

    @Test
    public void seventhPlayerTeamIdShouldBeEqualTeamId() {
        long playerTeamID = Storage.INSTANCE.getPlayers().get(6).getTeamID();
        Assert.assertEquals(SEVENTH_PLAYER_TEAM_ID, playerTeamID);
    }

    @Test
    public void fifthPlayerTeamIdShouldBeEqualTeamId() {
        long playerTeamID = Storage.INSTANCE.getPlayers().get(4).getTeamID();
        Assert.assertEquals(FIFTH_PLAYER_TEAM_ID, playerTeamID);
    }
}
