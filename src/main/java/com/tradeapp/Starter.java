package com.tradeapp;

import com.tradeapp.logic.TradeApp;

public class Starter {

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        TradeApp app = new TradeApp();
        app.start();
    }
}
