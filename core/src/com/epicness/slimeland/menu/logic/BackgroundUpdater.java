package com.epicness.slimeland.menu.logic;

import com.epicness.fundamentals.stuff.SharedStuff;

public class BackgroundUpdater {

    private SharedStuff sharedStuff;

    public void update(float delta) {
        sharedStuff.getAnimatedBackground().update(delta);
    }

    public void setSharedStuff(SharedStuff sharedStuff) {
        this.sharedStuff = sharedStuff;
    }
}