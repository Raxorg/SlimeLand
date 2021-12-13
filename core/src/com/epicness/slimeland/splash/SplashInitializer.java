package com.epicness.slimeland.splash;

import com.epicness.fundamentals.Initializer;
import com.epicness.fundamentals.SharedResources;

public class SplashInitializer extends Initializer {

    public SplashInitializer() {
        super(new SplashAssets());
    }

    @Override
    public void initialize(SharedResources sharedResources) {
        logic = new SplashLogic(sharedResources.getLogic());
        renderer = new SplashRenderer();
        stuff = new SplashStuff();
        super.initialize(sharedResources);
    }
}