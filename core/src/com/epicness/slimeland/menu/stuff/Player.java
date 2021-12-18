package com.epicness.slimeland.menu.stuff;

public class Player {

    private String name;
    private String colors;
    private int slimeQuantity;

    public Player(String name, String colors, int slimeQuantity) {
        this.name = name;
        this.colors = colors;
        this.slimeQuantity = slimeQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public int getSlimeQuantity() {
        return slimeQuantity;
    }

    public void setSlimeQuantity(int slimeQuantity) {
        this.slimeQuantity = slimeQuantity;
    }
}