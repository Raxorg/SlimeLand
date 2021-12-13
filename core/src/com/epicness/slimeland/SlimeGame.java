package com.epicness.slimeland;

import com.badlogic.gdx.Game;
import com.epicness.firebase.CoreFirestore;
import com.epicness.fundamentals.SharedResources;
import com.epicness.slimeland.game.GameAssets;
import com.epicness.slimeland.game.GameInitializer;

public class SlimeGame extends Game {

    private String phoneID;
    private CoreFirestore firestore;

    public SlimeGame(String phoneID, CoreFirestore firestore) {

    }

    @Override
    public void create() {
        new GameInitializer(new GameAssets()).initialize(new SharedResources(this));
    }

    public String getPhoneID() {
        return phoneID;
    }

    public CoreFirestore getFirestore() {
        return firestore;
    }
}