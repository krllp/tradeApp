package com.tradeapp.utils.parser;

import com.tradeapp.entities.TeamEntity;
import com.tradeapp.storage.Storage;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class TeamParserTest extends ParserTest{

    private static final int TEAMS_QNT = 3;

    private static final long FIRST_TEAM_ID = 1;
    private static final String FIRST_TEAM_NAME = "testNameTeam1";

    private static final long THIRD_TEAM_ID = 3;
    private static final String THIRD_TEAM_NAME = "testNameTeam3";

    @Test
    public void canParseTeams() throws IOException, ParseException {
        parseTeam();

        List<TeamEntity> teams = Storage.INSTANCE.getTeams();
        TeamEntity firstTeam = teamBuilder(FIRST_TEAM_ID, FIRST_TEAM_NAME);
        TeamEntity thirdTeam = teamBuilder(THIRD_TEAM_ID, THIRD_TEAM_NAME);

        assertNotNull(teams);
        assertEquals(TEAMS_QNT, teams.size());
        assertThat(
                teams,
                hasItems(
                        firstTeam,
                        thirdTeam
                )
        );
    }

    private void parseTeam() throws IOException, ParseException {
        JSONObject testJson = getTestJson();
        TeamParser.INSTANCE.parse(testJson);
    }

    private TeamEntity teamBuilder(long teamID, String teamName) {
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setID(teamID);
        teamEntity.setName(teamName);

        return teamEntity;
    }
}
