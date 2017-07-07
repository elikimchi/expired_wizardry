package com.company;

import edu.digipen.gameobject.GameObject;

import java.util.Random;

/**
 * Created by eli.kimchi on 7/7/2017.
 */
public class Cloud extends GameObject {
    float x;
    float y;
    public Cloud() {
        super("cloud", 52, 23, "cloud.png");
        x = 600.0f;
        Random rand = new Random();
        y = rand.nextInt(180) + 100;
        setPosition(x, y);
    }
    @Override public void update(float dt){
        x -= 1 + Level1.score / 500;

        if(!Level1.hasLost)
            setPositionX(x);

    }
}
