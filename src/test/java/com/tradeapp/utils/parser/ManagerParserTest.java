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
    private static final String FIRST_MANAGER_NAME = "testNameManager1";
    private static final String FIRST_MANAGER_LOGIN = "testLogin1";
    private static final String FIRST_MANAGER_PASSWORD = "testPass1";
    private static final long FIRST_MANAGER_TEAM_ID = 1;
    private static final String THIRD_MANAGER_NAME = "testNameManager3";
    private static final String THIRD_MANAGER_LOGIN = "testLogin3";
    private static final String THIRD_MANAGER_PASSWORD = "testPass3";
    private static final long THIRD_MANAGER_TEAM_ID = 3;

    @Test
    public void canParseManager() throws IOException, ParseException {
        parseManager();
        List<ManagerEntity> managers = Storage.INSTANCE.getManagers();
        assertNotNull(managers);
        assertEquals(MANAGERS_QNT, managers.size());

        ManagerEntity firstTestManager = new ManagerEntity();
        firstTestManager.setID((long) 1);
        firstTestManager.setName(FIRST_MANAGER_NAME);
        firstTestManager.setLogin(FIRST_MANAGER_LOGIN);
        firstTestManager.setPassword(FIRST_MANAGER_PASSWORD);
        firstTestManager.setTeamID(FIRST_MANAGER_TEAM_ID);

        ManagerEntity thirdTestManager = new ManagerEntity();
        thirdTestManager.setID((long) 3);
        thirdTestManager.setName(THIRD_MANAGER_NAME);
        thirdTestManager.setLogin(THIRD_MANAGER_LOGIN);
        thirdTestManager.setPassword(THIRD_MANAGER_PASSWORD);
        thirdTestManager.setTeamID(THIRD_MANAGER_TEAM_ID);

        assertThat(managers, hasItems(
                firstTestManager,
                thirdTestManager
        ));
    }

    private void parseManager() throws IOException, ParseException {
        JSONObject testJson = getTestJson();
        ManagerParser.INSTANCE.parse(testJson);
    }
}
