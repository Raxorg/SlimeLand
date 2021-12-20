package com.epicness.slimeland.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.epicness.firebase.CoreFirestore;
import com.epicness.firebase.ResultListener;
import com.epicness.slimeland.SlimeGame;
import com.epicness.slimeland.menu.stuff.Player;

import java.util.Map;

public class HtmlLauncher extends GwtApplication {

    @Override
    public GwtApplicationConfiguration getConfig() {
        // Resizable application, uses available space in browser
        return new GwtApplicationConfiguration(true);
        // Fixed size application:
        //return new GwtApplicationConfiguration(480, 320);
    }

    @Override
    public ApplicationListener createApplicationListener() {
        return new SlimeGame(new HTMLFirestore());
    }

    static class HTMLFirestore implements CoreFirestore {

        @Override
        public void registerPlayer(Player player, ResultListener<Void> successListener, ResultListener<String> colorsListener,
                                   ResultListener<String> errorListener) {

        }

        @Override
        public void fetchPlayerData(ResultListener<Map<String, Object>> playerDataListener) {

        }

        @Override
        public void incrementArmy(String playerName, ResultListener<Boolean> successListener) {

        }
    }
}