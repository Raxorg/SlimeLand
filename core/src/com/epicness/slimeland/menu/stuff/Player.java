package com.epicness.slimeland.menu.stuff;

public class Player {

    private final String name;
    private final String colors;
    private final int slimeQuantity, slimeStrength, slimeAgility;

    public Player(String name, String colors, int slimeQuantity, int slimeStrength, int slimeAgility) {
        this.name = name;
        this.colors = colors;
        this.slimeQuantity = slimeQuantity;
        this.slimeStrength = slimeStrength;
        this.slimeAgility = slimeAgility;
    }

    public String getName() {
        return name;
    }

    public String getColors() {
        return colors;
    }

    public int getSlimeQuantity() {
        return slimeQuantity;
    }

    public int getSlimeStrength() {
        return slimeStrength;
    }

    public int getSlimeAgility() {
        return slimeAgility;
    }
}