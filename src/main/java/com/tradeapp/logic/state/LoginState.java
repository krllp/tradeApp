package com.tradeapp.logic.state;

import com.tradeapp.entities.ManagerEntity;
import com.tradeapp.transition.State;
import com.tradeapp.transition.Transition;
import com.tradeapp.utils.authenticator.Authenticator;

import java.util.HashMap;
import java.util.Map;

public class LoginState implements StateLogic {

    @Override
    public void work(Map<String, Object> info) {
        LoginInfo loginInfo = getLoginInfo();
        ManagerEntity manager = Authenticator.INSTANCE.authorizeUser(loginInfo);
        if (manager != null) {
            Map<String, Object> rosterViewInfoMap = new HashMap<>();
            rosterViewInfoMap.put("teamId", manager.getTeamID());
            Transition.INSTANCE.go(State.ROSTER_VIEW, rosterViewInfoMap);
        }

    }

    private LoginInfo getLoginInfo() {
        System.out.println("ПРЕВЕТ ВЕДИТЕ ЛОГЕН ПОЖАЛУСТО");
        //TODO получение логина пароля
        return new LoginInfo("one", "two");
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

        }

        public Map<String, Object> toMap() {

        }
    }
}
