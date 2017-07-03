package com.company;

import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.math.Vec2;
import java.util.Random;

public class Cactus extends GameObject{
    float x;
    Random rand = new Random();
    int  n = rand.nextInt(10000) + 200;

    public Cactus() {
        super("Cactus", 75, 75, "1cactus.png");
        System.out.println(n);
        setRectangleCollider(25, 25);
        setPosition(n, 0);
        x = n;
    }

        @Override
    public void update(float dt) {
        --x;
        setPositionX(x);
    }
}
