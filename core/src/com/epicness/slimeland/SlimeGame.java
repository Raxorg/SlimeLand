package com.epicness.slimeland;

import com.badlogic.gdx.Game;
import com.epicness.firebase.CoreFirestore;
import com.epicness.firebase.FirebaseUtils;
import com.epicness.fundamentals.SharedResources;
import com.epicness.slimeland.splash.SplashInitializer;

public class SlimeGame extends Game {

    private final CoreFirestore firestore;

    public SlimeGame(CoreFirestore firestore) {
        this.firestore = firestore;
        FirebaseUtils.work();
    }

    @Override
    public void create() {
        new SplashInitializer().initialize(new SharedResources(this));
        //new PreferencesHandler().clearData(PREFS_PATH);
    }

    public CoreFirestore getFirestore() {
        return firestore;
    }
}