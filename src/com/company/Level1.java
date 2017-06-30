package com.company;

import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.level.GameLevel;

public class Level1 extends GameLevel {
    @Override
    public void create() {
        GameObject obj1 = new GameObject("Object1", 256, 64, "Paddle.png");
        ObjectManager.addGameObject(obj1);
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

