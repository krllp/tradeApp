package com.tradeapp.utils.authenticator;

import com.tradeapp.entities.ManagerEntity;
import com.tradeapp.logic.state.LoginState;

public class Authenticator {

    public static Authenticator INSTANCE = new Authenticator();

    public ManagerEntity authorizeUser(LoginState.LoginInfo loginInfo) {

        return new ManagerEntity();
    }
}
