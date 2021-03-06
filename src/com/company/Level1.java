package com.company;


import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.deploy.uitoolkit.Window;
import com.sun.media.jfxmediaimpl.platform.ios.IOSPlatform;
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
import java.io.*;
import java.security.Key;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;


public class Level1 extends GameLevel {
    float deadtime = 0;
    float spawncounter = 0;
    float clouddeadtime = 0;
    float cloudspawncounter = 0;
    static float high = 0;
    Random rand = new Random();
    int  n;
    public static float score = 0;

    public static boolean hasLost = false;

    ScoreDisplay display;
    ScoreDisplay hi;

    @Override
    public void create() {


        display = new ScoreDisplay(17, 13, 290, 230);
        hi = new ScoreDisplay(17, 13, 200, 230);

        Graphics.setDrawCollisionData(false);

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
    public void initialize(){

    }

    boolean upPressed = false;
    boolean spacePressed = false;
    @Override
    public void update(float dt) {

        if(hasLost)
        {
            GameObject hibutton = new High();
            ObjectManager.addGameObject(hibutton);
            hi.displayNumber((int) high);
            RestartButton restartButton = new RestartButton();
            ObjectManager.addGameObject(restartButton);
            GameObject gameover = new Gameover();
            ObjectManager.addGameObject(gameover);

                if (InputManager.isMouseButtonPressed(0) || (!spacePressed && InputManager.isPressed(KeyEvent.VK_SPACE)) || (!upPressed && InputManager.isPressed(KeyEvent.VK_UP))) {
                    hasLost = false;
                    GameLevelManager.goToLevel(new Level1());
                    Level1.score = 0;
                }

            upPressed = InputManager.isPressed(KeyEvent.VK_UP);
            spacePressed = InputManager.isPressed(KeyEvent.VK_SPACE);
            return;
        }


        score += .15;
        display.displayNumber((int) score);
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

        n = rand.nextInt(99) + 1;
        clouddeadtime += dt;
        if (clouddeadtime >= 75 * dt) {
            cloudspawncounter += dt * 10;
            if (n <= cloudspawncounter) {
                clouddeadtime = 0;
                cloudspawncounter = 0;
                GameObject cloud = new Cloud();
                ObjectManager.addGameObject(cloud);
            }
        }

        GameObject hibutton = new High();
        ObjectManager.addGameObject(hibutton);
        if(score > high){
            high = score;
        }
        hi.displayNumber((int) high);

        upPressed = InputManager.isPressed(KeyEvent.VK_UP);
        spacePressed = InputManager.isPressed(KeyEvent.VK_SPACE);
    }

    @Override
    public void uninitialize() {

    }


}

