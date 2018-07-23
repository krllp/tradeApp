package com.tradeapp.transition;

import java.util.Map;

public class Transition {

    public static Transition INSTANCE = new Transition();

    private Transition() {
    }

    public void go(State state, Map<String, Object> info) {
        state.work(info);
    }
}
