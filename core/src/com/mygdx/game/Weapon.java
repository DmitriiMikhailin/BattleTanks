package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Weapon {
    private Texture texture;
    private float firePeriod;
    private int damage;

    public Weapon() {
        texture = new Texture("simple_weapon.png");
        firePeriod = 0.4f;
        damage = 1;
    }

    public float getFirePeriod() {
        return firePeriod;
    }

    public Texture getTexture() {
        return texture;
    }

    public int getDamage() {
        return damage;
    }
}
