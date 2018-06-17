package com.tradeapp.utils.parser;

import com.tradeapp.entities.ManagerEntity;
import com.tradeapp.storage.Storage;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

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
        assertEquals(FIRST_MANAGER_NAME, managers.get(0).getName());
        assertEquals(FIRST_MANAGER_LOGIN, managers.get(0).getLogin());
        assertEquals(FIRST_MANAGER_PASSWORD, managers.get(0).getPassword());
        assertEquals(FIRST_MANAGER_TEAM_ID, (long) managers.get(0).getTeamID());
        assertEquals(THIRD_MANAGER_NAME, managers.get(2).getName());
        assertEquals(THIRD_MANAGER_LOGIN, managers.get(2).getLogin());
        assertEquals(THIRD_MANAGER_PASSWORD, managers.get(2).getPassword());
        assertEquals(THIRD_MANAGER_TEAM_ID, (long) managers.get(2).getTeamID());
    }

    private void parseManager() throws IOException, ParseException {
        JSONObject testJson = getTestJson();
        ManagerParser.INSTANCE.parse(testJson);
    }
}
