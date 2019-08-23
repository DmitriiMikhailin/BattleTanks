package com.mygdx.game.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Weapon;
import com.mygdx.game.utils.Direction;

import static com.mygdx.game.utils.Direction.UP;

public class BotTank extends Tank {
    Direction preferredDirection;
    float aiTimer;
    float aiTimerTo;
    boolean active;

    public boolean isActive() {
        return active;
    }

    public BotTank(MyGdxGame game) {
        super(game);
        this.game = game;
        this.texture = new Texture("bot_tank_base.png");
        this.weapon = new Weapon();
        this.position = new Vector2();
        this.speed = 100;
        this.width = texture.getWidth();
        this.height = texture.getHeight();
        this.hpMax = 10;
        this.hp = this.hpMax;
        aiTimerTo = 3;
    }

    public void update(float dt) {
        aiTimer += dt;
        if (aiTimer >= aiTimerTo) {
            aiTimer = 0;
            aiTimerTo = MathUtils.random(2.5f, 4f);
            preferredDirection = Direction.values()[MathUtils.random(0, Direction.values().length - 1)];
            angle = preferredDirection.getAngle();
        }
        position.add(speed * preferredDirection.getVx() * dt, speed * preferredDirection.getVy() * dt);
    }

    public void activate(float x, float y) {
        position.set(x, y);
        preferredDirection = Direction.values()[MathUtils.random(0, Direction.values().length - 1)];
        angle = preferredDirection.getAngle();
        aiTimer = 0;
        active = true;
    }
}
