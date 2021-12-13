package com.epicness.slimeland;

import com.badlogic.gdx.Game;
import com.epicness.firebase.CoreFirestore;
import com.epicness.fundamentals.SharedResources;
import com.epicness.slimeland.splash.SplashInitializer;

public class SlimeGame extends Game {

    private final String phoneID;
    private final CoreFirestore firestore;

    public SlimeGame(String phoneID, CoreFirestore firestore) {
        this.phoneID = phoneID;
        this.firestore = firestore;
    }

    @Override
    public void create() {
        new SplashInitializer().initialize(new SharedResources(this));
    }

    public String getPhoneID() {
        return phoneID;
    }

    public CoreFirestore getFirestore() {
        return firestore;
    }
}