package com.epicness.slimeland.splash;

import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.slimeland.menu.MenuAssets;
import com.epicness.slimeland.menu.MenuInitializer;

public class SplashLogic extends Logic {

    public SplashLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
    }

    @Override
    public void initialLogic() {
        sharedLogic.getTransitionHandler().startTransition(new MenuInitializer());
        sharedLogic.getTransitionHandler().allowTransition();
    }

    @Override
    public void update(float delta) {
        sharedLogic.getAssetLoader().update();
        sharedLogic.getTransitionHandler().update();
    }
}
