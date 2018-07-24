package com.tradeapp.utils.authenticator;

import com.tradeapp.entities.ManagerEntity;
import com.tradeapp.logic.state.LoginState;
import com.tradeapp.storage.Storage;

import java.util.List;

public class Authenticator {

    public static Authenticator INSTANCE = new Authenticator();

    private ManagerEntity authManager;

    public ManagerEntity authorizeUser(LoginState.LoginInfo loginInfo) {
        return managerAccess(loginInfo);
    }

    private ManagerEntity managerAccess(LoginState.LoginInfo loginInfo) {
        String login = loginInfo.getLogin();
        String password = loginInfo.getPassword();

        if (isAuthSuccessful(login, password))
            return authManager;

        return null;
    }

    private boolean isAuthSuccessful(String login, String password) {
        boolean isAuth = false;

        List<ManagerEntity> managerEntities = Storage.INSTANCE.getManagers();

        for (ManagerEntity manager : managerEntities) {
            if (login.equals(manager.getLogin()) && password.equals(manager.getPassword())) {
                isAuth = true;
                authManager = manager;
                break;
            }
        }

        return isAuth;
    }
}
