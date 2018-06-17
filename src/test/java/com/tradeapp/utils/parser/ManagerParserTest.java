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

    @Test
    public void canParseManager() throws IOException, ParseException {
        parseManager();
        List<ManagerEntity> managers = Storage.INSTANCE.getManagers();
        assertNotNull(managers);
        assertEquals(MANAGERS_QNT, managers.size());
        //TODO допиши тесты епта
    }

    private void parseManager() throws IOException, ParseException {
        JSONObject testJson = getTestJson();
        ManagerParser.INSTANCE.parse(testJson);
    }
}
