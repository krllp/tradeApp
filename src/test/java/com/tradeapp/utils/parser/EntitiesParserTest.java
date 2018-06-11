package com.tradeapp.utils.parser;

import com.tradeapp.entities.PlayerEntity;
import com.tradeapp.entities.TeamEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class EntitiesParserTest {

    private static final String FILE_NAME = "teams.test.json";
    private static final String TEAM_NAME = "testNameTeam";
    private static final String MANAGER_NAME = "testNameManager";
    private static final String MANAGER_LOGIN = "testLogin";
    private static final String MANAGER_PASSWORD = "testPass";
    private static final String PLAYER_NAME = "testNamePlayer";
    private static final int PLAYER_SALARY = 100;

    private List<TeamEntity> teamsList;
    private String teamName;
    private String managerName;
    private String managerLogin;
    private String managerPass;
    private String playerName;
    private int playerSalary;

    @Before
    public void createNewTeamEntityList() {
        teamsList = EntitiesParser.INSTANCE.parse(FILE_NAME);

        for(TeamEntity team : teamsList) {
            teamName = team.getName();
            managerName = team.getManager().getName();
            managerLogin = team.getManager().getLogin();
            managerPass = team.getManager().getPassword();
            for(PlayerEntity player : team.getPlayers()) {
                playerName = player.getName();
                playerSalary = player.getSalary();
            }
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
}
