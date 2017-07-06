package com.company;


import com.sun.deploy.uitoolkit.Window;
import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.graphics.Graphics;
import edu.digipen.level.GameLevel;

import java.util.Random;


public class Level1 extends GameLevel {
    float deadtime = 0;
    float spawncounter = 0;
    Random rand = new Random();
    int  n;
    public static float score = 0;

    ScoreDisplay display;

    @Override
    public void create() {


        display = new ScoreDisplay(16, 12, 300, 230);

        Graphics.setDrawCollisionData(true);

        Graphics.setBackgroundColor(0.96862745098f, 0.96862745098f, 0.96862745098f);



        GameObject player = new Dinosaur();
        ObjectManager.addGameObject(player);



        GameObject ground = new Ground();
        ObjectManager.addGameObject(ground);
        ground.setPosition(0, -30);

        GameObject ground2 = new Ground();
        ObjectManager.addGameObject(ground2);
        ground2.setPosition(1088, -30);

    }



    @Override
    public void initialize() {

    }

    @Override
    public void update(float dt) {

        score += .12;
        display.displayNumber((int)score);

        n = rand.nextInt(99) + 1;
        deadtime += dt;
        if(deadtime >= 42 * dt ){
            spawncounter += dt * 10;
            if(n <= spawncounter){
                deadtime = 0;
                spawncounter = 0;
                GameObject cactus = new Cactus();
                ObjectManager.addGameObject(cactus);
            }
        }
    }

    @Override
    public void uninitialize() {

    }


}

