package com.tradeapp.logic.state;

import com.tradeapp.entities.ManagerEntity;
import com.tradeapp.transition.State;
import com.tradeapp.transition.Transition;
import com.tradeapp.utils.authenticator.Authenticator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LoginState implements StateLogic {

    private static final String FIRST_AUTH_MESSAGE = "ПРЕВЕТ ВЕДИТЕ ЛОГЕН А ЗАТЕМ ПОРОЛЬ ПОЖАЛУСТО";
    private static final String WRONG_AUTH_MESSAGE = "ЛОГЕН ИЛИ ПОРОЛЬ НЕПРАВИЛЬНЫЕ ПОПРОБУЙТЕ ЗАНОГО";

    private Boolean isFirstAuth = true;

    @Override
    public void work(Map<String, Object> info) {
        LoginInfo loginInfo = getLoginInfo();
        ManagerEntity manager = Authenticator.INSTANCE.authorizeUser(loginInfo);
        if (manager != null) {
            Map<String, Object> rosterViewInfoMap = new HashMap<>();
            rosterViewInfoMap.put("teamId", manager.getTeamID());
            Transition.INSTANCE.go(State.ROSTER_VIEW, rosterViewInfoMap);
        } else {
            isFirstAuth = false;
            Transition.INSTANCE.go(State.LOGIN, Collections.emptyMap());
        }
    }

    private LoginInfo getLoginInfo() {
        if (isFirstAuth)
            System.out.println(FIRST_AUTH_MESSAGE);
        else
            System.out.println(WRONG_AUTH_MESSAGE);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String login = null;
        String password = null;
        try {
            login = bufferedReader.readLine();
            password = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new LoginInfo(login, password);
    }

    public class LoginInfo {
        private final String login;
        private final String password;

        public LoginInfo(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public void fromMap(Map<String, Object> map) {
            //TODO запилить from и to map и вынести их
        }

        public Map<String, Object> toMap() {
            return Collections.emptyMap();
        }
    }
}
