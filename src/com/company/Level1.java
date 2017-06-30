package com.company;

import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.level.GameLevel;

public class Level1 extends GameLevel {
    @Override
    public void create() {
        GameObject player = new Paddle();
        ObjectManager.addGameObject(player);

        GameObject enemy = new Enemy();
        ObjectManager.addGameObject(enemy);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void update(float v) {


    }

    @Override
    public void uninitialize() {

    }


}

