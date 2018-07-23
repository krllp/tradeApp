package com.tradeapp.utils.parser;

import com.tradeapp.entities.PlayerEntity;
import com.tradeapp.storage.Storage;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class PlayersParserTest extends ParserTest {

    private static final int PLAYERS_QNT = 8;

    private static final long FIRST_PLAYER_ID = 1;
    private static final String FIRST_PLAYER_NAME = "testNamePlayer1";
    private static final int FIRST_PLAYER_SALARY = 100;
    private static final long FIRST_PLAYER_TEAM_ID = 1;

    private static final long FIFTH_PLAYER_ID = 5;
    private static final String FIFTH_PLAYER_NAME = "testNamePlayer5";
    private static final int FIFTH_PLAYER_SALARY = 500;
    private static final long FIFTH_PLAYER_TEAM_ID = 2;

    private static final long EIGHTH_PLAYER_ID = 8;
    private static final String EIGHTH_PLAYER_NAME = "testNamePlayer8";
    private static final int EIGHTH_PLAYER_SALARY = 800;
    private static final long EIGHTH_PLAYER_TEAM_ID = 3;

    @Test
    public void canParsePlayers() throws IOException, ParseException {
        parsePlayers();

        List<PlayerEntity> players = Storage.INSTANCE.getPlayers();
        PlayerEntity firstPlayer = playerBuilder(
                FIRST_PLAYER_ID,
                FIRST_PLAYER_NAME,
                FIRST_PLAYER_SALARY,
                FIRST_PLAYER_TEAM_ID
        );
        PlayerEntity fifthPlayer = playerBuilder(
                FIFTH_PLAYER_ID,
                FIFTH_PLAYER_NAME,
                FIFTH_PLAYER_SALARY,
                FIFTH_PLAYER_TEAM_ID
        );
        PlayerEntity eighthPlayer = playerBuilder(
                EIGHTH_PLAYER_ID,
                EIGHTH_PLAYER_NAME,
                EIGHTH_PLAYER_SALARY,
                EIGHTH_PLAYER_TEAM_ID
        );

        assertNotNull(players);
        assertEquals(PLAYERS_QNT, players.size());
        assertThat(
                players,
                hasItems(
                        firstPlayer,
                        fifthPlayer,
                        eighthPlayer
                )
        );
    }

    private void parsePlayers() throws IOException, ParseException {
        JSONObject testJson = getTestJson();
        PlayersParser.INSTANCE.parse(testJson);
    }

    private PlayerEntity playerBuilder(
            long playerID,
            String playerName,
            int playerSalary,
            long playerTeamID
    ) {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setID(playerID);
        playerEntity.setName(playerName);
        playerEntity.setSalary(playerSalary);
        playerEntity.setTeamID(playerTeamID);

        return playerEntity;
    }
}
