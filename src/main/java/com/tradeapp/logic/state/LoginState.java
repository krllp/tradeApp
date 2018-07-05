package com.tradeapp.logic.state;

import com.tradeapp.utils.authenticator.Authenticator;

import java.util.Map;

public class LoginState implements StateLogic {

    @Override
    public void work(Map<String, Object> info) {
        LoginInfo a = map(info);
        LoginInfo loginInfo = getLoginInfo();
        Authenticator.INSTANCE.authorizeUser(loginInfo);
        String login = (String) info.get("login");

    }

    private LoginInfo map(Map<String, Object> info) {
        String login = (String) info.get("login");
        String pass = (String) info.get("pass");
        LoginInfo loginInfo = new LoginInfo(login, pass);
        return loginInfo;
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
    }
}
