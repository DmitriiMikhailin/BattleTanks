package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.units.BotTank;

public class BotEmitter {
    private BotTank[] bots;
    private static final int MAX_BOTS = 10;

    public BotEmitter(MyGdxGame game) {
        this.bots = new BotTank[MAX_BOTS];
        for (int i = 0; i < bots.length; i++) {
            bots[i] = new BotTank(game);
        }
    }

    public BotTank[] getBots() {
        return bots;
    }

    public void update(float dt) {
        for (int i = 0; i < bots.length; i++) {
            if (bots[i].isActive()) {
                bots[i].update(dt);
            }
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < bots.length; i++) {
            if (bots[i].isActive()) {
                bots[i].render(batch);
            }
        }
    }

    public void activate(float x, float y) {
        for (int i = 0; i < bots.length; i++) {
            if (!bots[i].isActive()) {
                bots[i].activate(x, y);
                break;
            }
        }
    }
}
