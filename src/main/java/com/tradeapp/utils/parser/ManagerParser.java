package com.tradeapp.utils.parser;

import com.tradeapp.entities.ManagerEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ManagerParser implements EntitiesParserInterface{

    /**
     * Метод получения менеджера из json-объекта
     * @param managerArray спарсенные данные менеджера
     * @return Сущность менеджера команды
     */
    @Override
    public ManagerEntity parse(JSONArray managerArray) {
        ManagerEntity managerEntity = new ManagerEntity();
        for(Object o : managerArray) {
            JSONObject manager = (JSONObject) o;
            managerEntity.setName((String) manager.get(JsonKeys.MANAGER_NAME));
            managerEntity.setLogin((String) manager.get(JsonKeys.MANAGER_LOGIN));
            managerEntity.setPassword((String) manager.get(JsonKeys.MANAGER_PASS));
        }

        return managerEntity;
    }

    private class JsonKeys {
        private static final String MANAGER_NAME = "name";
        private static final String MANAGER_LOGIN = "login";
        private static final String MANAGER_PASS = "pass";
    }
}
