package com.tradeapp.utils.parser;

import com.tradeapp.entities.ManagerEntity;
import com.tradeapp.storage.Storage;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ManagerParserTest extends ParserTest {

    private static final int MANAGERS_QNT = 3;

    private static final long FIRST_MANAGER_ID = 1;
    private static final String FIRST_MANAGER_NAME = "testNameManager1";
    private static final String FIRST_MANAGER_LOGIN = "testLogin1";
    private static final String FIRST_MANAGER_PASSWORD = "testPass1";
    private static final long FIRST_MANAGER_TEAM_ID = 1;

    private static final long THIRD_MANAGER_ID = 3;
    private static final String THIRD_MANAGER_NAME = "testNameManager3";
    private static final String THIRD_MANAGER_LOGIN = "testLogin3";
    private static final String THIRD_MANAGER_PASSWORD = "testPass3";
    private static final long THIRD_MANAGER_TEAM_ID = 3;

    @Test
    public void canParseManager() throws IOException, ParseException {
        parseManager();

        List<ManagerEntity> managers = Storage.INSTANCE.getManagers();
        ManagerEntity firstTestManager = managerBuilder(
                FIRST_MANAGER_ID,
                FIRST_MANAGER_NAME,
                FIRST_MANAGER_LOGIN,
                FIRST_MANAGER_PASSWORD,
                FIRST_MANAGER_TEAM_ID
        );
        ManagerEntity thirdTestManager = managerBuilder(
                THIRD_MANAGER_ID,
                THIRD_MANAGER_NAME,
                THIRD_MANAGER_LOGIN,
                THIRD_MANAGER_PASSWORD,
                THIRD_MANAGER_TEAM_ID
        );


        assertNotNull(managers);
        assertEquals(MANAGERS_QNT, managers.size());
        assertThat(
                managers,
                hasItems(
                        firstTestManager,
                        thirdTestManager
                )
        );
    }

    private void parseManager() throws IOException, ParseException {
        JSONObject testJson = getTestJson();
        ManagerParser.INSTANCE.parse(testJson);
    }

    private ManagerEntity managerBuilder(long managerID, String managerName, String managerLogin, String managerPass, long managerTeamID) {
        ManagerEntity managerEntity = new ManagerEntity();
        managerEntity.setID(managerID);
        managerEntity.setName(managerName);
        managerEntity.setLogin(managerLogin);
        managerEntity.setPassword(managerPass);
        managerEntity.setTeamID(managerTeamID);

        return managerEntity;
    }
}
