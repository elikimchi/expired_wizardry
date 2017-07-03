package com.company;

import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.graphics.Graphics;
import edu.digipen.level.GameLevel;


public class Level1 extends GameLevel {
    @Override
    public void create() {
        Graphics.setDrawCollisionData(true);

       Graphics.setBackgroundColor(0.96862745098f, 0.96862745098f, 0.96862745098f);

        GameObject player = new Dinosaur();
        ObjectManager.addGameObject(player);

        for (int i = 0; i < 10; i++) {
            GameObject cactus = new Cactus();
            ObjectManager.addGameObject(cactus);
        }
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

