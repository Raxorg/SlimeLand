package com.epicness.slimeland.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.epicness.firebase.CoreFirestore;
import com.epicness.firebase.ResultListener;
import com.epicness.slimeland.SlimeGame;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.forceExit = false;

        new LwjglApplication(new SlimeGame("", new DesktopFirestore()), config);
    }

    static class DesktopFirestore implements CoreFirestore {

        @Override
        public void registerPlayer(String playerID, ResultListener<Boolean> listener) {

        }
    }
}