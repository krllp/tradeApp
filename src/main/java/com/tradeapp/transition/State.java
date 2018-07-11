package com.tradeapp.transition;

import com.tradeapp.logic.state.LoginState;
import com.tradeapp.logic.state.RosterViewState;
import com.tradeapp.logic.state.StateLogic;

import java.util.Map;

public enum State {

    LOGIN(new LoginState()),
    ROSTER_VIEW(new RosterViewState()),
    ;

    private final StateLogic stateLogic;

    State(StateLogic stateLogic) {
        this.stateLogic = stateLogic;
    }

    public void work(Map<String, Object> info) {
        stateLogic.work(info);
    }
}
