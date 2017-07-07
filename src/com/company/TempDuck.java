package com.company;

import edu.digipen.Game;
import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.level.GameLevelManager;
import edu.digipen.math.Vec2;

import java.awt.event.KeyEvent;

/**
 * Created by jack.notarangelo on 7/6/2017.
 */


public class TempDuck extends GameObject{
    TempDuck(){
        super("TempDuck", 1, 1, "none.png");
        setRectangleCollider(25, 10);
        setPosition(-250, -9);
    }
    @Override
    public void collisionReaction(GameObject collidedWith) {
        if(InputManager.isPressed(KeyEvent.VK_DOWN)){


            Level1.hasLost = true;
        }
    }

}