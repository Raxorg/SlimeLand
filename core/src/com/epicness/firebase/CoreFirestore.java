package com.epicness.firebase;

import com.epicness.slimeland.menu.stuff.Player;

public interface CoreFirestore {

    void registerPlayer(Player player, ResultListener<Boolean> successListener, ResultListener<String> errorListener);
}