package com.epicness.slimeland;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class SlimeConstants {

    // Preferences
    public static final String PREFS_PATH = "EpicnessSlimeLandPrefs";
    public static final String NAME_PREF_KEY = "name";
    public static final String COLORS_PREF_KEY = "colors";
    public static final String SLIME_QUANTITY_PREF_KEY = "slimeQuantity";
    public static final String SLIME_STRENGTH_PREF_KEY = "slimeStrength";
    public static final String SLIME_AGILITY_PREF_KEY = "slimeAgility";

    public static final String ANTENNA_COOLDOWN_PREF_KEY = "antennaCooldown";
    public static final String FACTORY_COOLDOWN_PREF_KEY = "factoryCooldown";
    public static final String TOWER_COOLDOWN_PREF_KEY = "towerCooldown";
    public static final String KILLS_PREF_KEY = "kills";
    public static final String TD_LEVEL_KEY = "TDLevel";

    public static final String BUILD_CHARGES_PREF_KEY = "buildCharges";
    public static final String BUILDING_PREFS_PATH = "EpicnessSlimeLandPrefsBuildings";
    // Other
    public static final float HIDDEN_X = CAMERA_WIDTH * 2f;
    public static final float HIDDEN_Y = CAMERA_HEIGHT * 2f;
}