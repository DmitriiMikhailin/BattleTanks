package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {
    private static final int SIZE_X = 32;
    private static final int SIZE_Y = 18;
    private static final int CELL_SIZE = 40;

    private Texture grassTexture;

    public Map() {
        this.grassTexture = new Texture("grass.png");
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                batch.draw(grassTexture, i * CELL_SIZE, j * CELL_SIZE);
            }
        }
    }
}
