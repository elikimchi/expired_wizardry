package com.company;

import edu.digipen.gameobject.GameObject;
import edu.digipen.math.Vec2;

/**
 * Created by jack.notarangelo on 7/3/2017.
 */
public class Gameover extends GameObject{
    public Gameover() {
        super("gameover", 170, 50, "gameover.png");
        setPosition(new Vec2(0, 100));
    }
}
