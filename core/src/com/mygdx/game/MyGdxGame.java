package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.units.PlayerTank;
import com.mygdx.game.units.Tank;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private PlayerTank player;
    private BulletEmitter bulletEmitter;
    private BotEmitter botEmitter;
    private Map map;
    private float gameTimer;

    public BulletEmitter getBulletEmitter() {
        return bulletEmitter;
    }

    // прицеливание мышкой
    // эмиттер пуль
    // отделить башню от корпуса
    // завести константы
    // не выходить за экран
    // разрушаемые стены (материал)
    // размер 48*48
    // боты
    // разные виды оружия
    // полоса хп
    // поверапс


    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new PlayerTank(this);
        bulletEmitter = new BulletEmitter();
        botEmitter = new BotEmitter(this);
		botEmitter.activate(MathUtils.random(0, Gdx.graphics.getWidth()),
				MathUtils.random(0, Gdx.graphics.getHeight()));
        map = new Map();
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        update(dt);
        Gdx.gl.glClearColor(0, 0.6f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        map.render(batch);
        player.render(batch);
        botEmitter.render(batch);
        bulletEmitter.render(batch);
        batch.end();
    }

    public void update(float dt) {
        gameTimer += dt;
        if (gameTimer > 10) {
            gameTimer = 0;
            botEmitter.activate(MathUtils.random(0, Gdx.graphics.getWidth()),
                    MathUtils.random(0, Gdx.graphics.getHeight()));
        }
        player.update(dt);
        botEmitter.update(dt);
        bulletEmitter.update(dt);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
