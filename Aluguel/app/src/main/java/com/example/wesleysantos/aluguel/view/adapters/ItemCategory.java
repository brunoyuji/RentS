package com.example.wesleysantos.aluguel.view.adapters;

/**
 * Created by wesleysantos on 13/03/17.
 */

public class ItemCategory  {
    private int image;
    private String name;

    public ItemCategory(String name, int image) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
