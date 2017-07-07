package com.company;

import edu.digipen.gameobject.GameObject;
import edu.digipen.math.Vec2;

/**
 * Created by eli.kimchi on 7/6/2017.
 */
public class RestartButton extends GameObject{
    public RestartButton() {
        super("restart", 39, 35, "restart.png");
        setPosition(new Vec2(0,0));
    }
}
