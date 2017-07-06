package com.company;

import edu.digipen.Game;
import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;

import java.awt.event.KeyEvent;

/**
 * Created by jack.notarangelo on 7/6/2017.
 */


public class TempDuck extends GameObject{
    TempDuck(){
        super("TempDuck", 1, 1, "none.png");
        setRectangleCollider(18, 23);
        setPosition(-250, -5);
    }
    @Override
    public void collisionReaction(GameObject collidedWith) {
        if(InputManager.isPressed(KeyEvent.VK_DOWN)){
            Game.destroy();
        }
    }

}