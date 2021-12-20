package com.epicness.firebase;

import com.epicness.slimeland.menu.stuff.Player;

import java.util.Map;

public interface CoreFirestore {

    void fetchVersion(ResultListener<String> versionListener);

    void registerPlayer(Player player, ResultListener<Void> successListener, ResultListener<String> colorsListener,
                        ResultListener<String> errorListener);

    void fetchPlayerData(ResultListener<Map<String, Object>> playerDataListener);

    void incrementArmy(String playerName, ResultListener<Boolean> successListener);
}