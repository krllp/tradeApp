package com.tradeapp.utils.parser;

import com.tradeapp.config.AppConfig;
import org.junit.Assert;
import org.junit.Test;

public class AppConfigParserTest {

    private static final String FILE_NAME = "config.test.json";
    private static final String TEST_PATH_TO_FILE = "testPath";

    @Test
    public void canParseConfigJson() {
        AppConfig cfg = AppConfigParser.INSTANCE.parse(FILE_NAME);
        Assert.assertEquals(TEST_PATH_TO_FILE, cfg.getPathToFile());
    }
}
