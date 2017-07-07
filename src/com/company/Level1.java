package com.company;


import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.deploy.uitoolkit.Window;
import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.graphics.Graphics;
import edu.digipen.level.GameLevel;
import edu.digipen.level.GameLevelManager;
import edu.digipen.math.Vec2;
import javafx.scene.input.MouseButton;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.logging.Level;


public class Level1 extends GameLevel {
    float deadtime = 0;
    float spawncounter = 0;
    Random rand = new Random();
    int  n;
    public static float score = 0;

    public static boolean hasLost = false;

    ScoreDisplay display;

    @Override
    public void create() {


        display = new ScoreDisplay(17, 13, 290, 230);

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

        if(hasLost)
        {
            RestartButton restartButton = new RestartButton();
            ObjectManager.addGameObject(restartButton);
            GameObject gameover = new Gameover();
            ObjectManager.addGameObject(gameover);
            if(InputManager.isMouseButtonPressed(0) || InputManager.isPressed(KeyEvent.VK_UP) || InputManager.isPressed(KeyEvent.VK_SPACE))
            {


                hasLost = false;
                GameLevelManager.goToLevel(new Level1());
                Level1.score = 0;

            }

            return;
        }


        score += .15;
        display.displayNumber((int)score);
        if(score < 401) {
            n = rand.nextInt(99) + 1;
            deadtime += dt;
            if (deadtime >= 35 * dt) {
                spawncounter += dt * 10;
                if (n <= spawncounter) {
                    deadtime = 0;
                    spawncounter = 0;
                    GameObject cactus = new Cactus();
                    ObjectManager.addGameObject(cactus);
                }
            }
        } else {
            n = rand.nextInt(99) + 1;
            deadtime += dt;
            if (deadtime >= 35 * dt) {
                spawncounter += dt * 10;
                if (n <= spawncounter) {
                    deadtime = 0;
                    spawncounter = 0;
                    int rano = rand.nextInt(2) + 1;
                    if(rano == 2){
                        GameObject ptero = new Ptero();
                        ObjectManager.addGameObject(ptero);
                    } else{
                        GameObject cactus = new Cactus();
                        ObjectManager.addGameObject(cactus);
                    }
                }
            }
        }
    }

    @Override
    public void uninitialize() {

    }


}

