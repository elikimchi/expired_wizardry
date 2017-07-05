package com.company;

import edu.digipen.gameobject.GameObject;

/**
 * Created by jack.notarangelo on 7/5/2017.
 */
public class Ground extends GameObject {

    int x;
    public Ground() {
        super("Ground", 548, 13, "ground.png");
        //System.out.println(n);
        //setRectangleCollider(25, 25);
        setPosition(0, -30);
        //x = n;
        //x = getPositionX();
    }

    @Override
    public void update(float dt) {
        x -= 2;
        setPositionX(x);
    }
}
