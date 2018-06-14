package com.tradeapp.utils.parser;

import org.json.simple.JSONArray;

public interface EntitiesParserInterface<T> {

    T parse(JSONArray jsonArray);
}
