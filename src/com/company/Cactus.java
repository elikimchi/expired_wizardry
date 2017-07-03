package com.company;

import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.math.Vec2;

public class Cactus extends GameObject{
    float x;
    public Cactus() {
        super("Cactus", 75, 75, "Paddle.png");
        setPosition(200, 0);
        x = 200;
    }

    @Override
    public void update(float dt) {
        --x;
        setPositionX(x);
    }
}
