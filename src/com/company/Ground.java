package com.company;

import edu.digipen.gameobject.GameObject;

/**
 * Created by jack.notarangelo on 7/5/2017.
 */
public class Ground extends GameObject {

    float x;
    public Ground() {
        super("Ground", 1096, 13, "ground.png");
        //setRectangleCollider(25, 25);
        //setPosition(500, -30);
        //x = n;
        //x = getPositionX();
    }

    @Override
    public void update(float dt) {
        x = getPositionX();
        x -= 3;
        if (x < -1086){
            x = 1088;
        }
        setPositionX(x);
    }
}
