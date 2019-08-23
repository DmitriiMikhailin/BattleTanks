package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Bullet {
    private Vector2 position;
    private Vector2 velocity;
    private int damage;
    private boolean active;

    public Bullet() {
        this.position = new Vector2();
        this.velocity = new Vector2();
        this.damage = 0;
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void update(float dt) {
        position.mulAdd(velocity, dt);

        if (position.x < 0.0f || position.x > 1280.0f || position.y < 0.0f || position.y > 720.0f) {
            deactivate();
        }
    }

    public void deactivate() {
        active = false;
    }

    public void activate(float x, float y, float vx, float vy, int damage) {
        this.position.set(x,y);
        this.velocity.set(vx,vy);
        this.damage = damage;
        this.active = true;
    }
}
