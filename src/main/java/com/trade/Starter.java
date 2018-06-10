package com.trade;

import com.trade.logic.TradeApp;

public class Starter {

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        TradeApp app = new TradeApp();
        app.start();
    }
}
