package com.epicness.slimeland.game.logic;

import com.epicness.slimeland.SlimeGame;

public class PlayerRegistrator {

    private SlimeGame game;

    public void registerPlayer() {
        game.getFirestore().registerPlayer(game.getPhoneID(), System.out::println);
    }

    public void setGame(SlimeGame game) {
        this.game = game;
    }
}