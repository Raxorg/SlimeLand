package com.epicness.slimeland.menu.stuff;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.fundamentals.SharedConstants.OPAQUE_TRANSPARENT;
import static com.epicness.fundamentals.SharedConstants.TRANSPARENT;
import static com.epicness.slimeland.menu.MenuConstants.CHECK_SIZE;
import static com.epicness.slimeland.menu.MenuConstants.CHOOSE_TEXT_HEIGHT;
import static com.epicness.slimeland.menu.MenuConstants.CHOOSE_TEXT_WIDTH;
import static com.epicness.slimeland.menu.MenuConstants.CHOOSE_TEXT_Y;

import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedText;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.slimeland.menu.MenuAssets;

public class MenuStuff extends Stuff {

    private SlimeGrid slimeGrid;
    private Sprited slimeSelector;
    private SpritedText chooseText;
    private SpritedText loadingOverlay;

    @Override
    public void initializeStuff() {
        MenuAssets assets = (MenuAssets) this.assets;

        slimeGrid = new SlimeGrid(assets);

        slimeSelector = new Sprited(assets.getCheck());
        slimeSelector.setSize(CHECK_SIZE);

        chooseText = new SpritedText(sharedAssets.getPixel(), assets.getPixelFont());
        chooseText.setY(CHOOSE_TEXT_Y);
        chooseText.setSize(CHOOSE_TEXT_WIDTH, CHOOSE_TEXT_HEIGHT);
        chooseText.setColor(TRANSPARENT);
        chooseText.setText("Choose your colors");

        loadingOverlay = new SpritedText(sharedAssets.getPixel(), assets.getBiggerPixelFont());
        loadingOverlay.setSize(CAMERA_WIDTH,CAMERA_HEIGHT);
        loadingOverlay.setColor(OPAQUE_TRANSPARENT);
        loadingOverlay.setText("Thonking");
    }

    public SlimeGrid getSlimeGrid() {
        return slimeGrid;
    }

    public Sprited getSlimeSelector() {
        return slimeSelector;
    }

    public SpritedText getChooseText() {
        return chooseText;
    }

    public SpritedText getLoadingOverlay() {
        return loadingOverlay;
    }
}