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
public class TempRun extends GameObject{


    private boolean hasLost = false;

    public TempRun(){
        super("temprun", 1, 1, "none.png");
        setRectangleCollider(14, 22);
        setPosition(-254, -5);
    }
    @Override public void update(float dt){
        GameObject player = ObjectManager.getGameObjectByName("Player");
        setPositionY(player.getPositionY());


    }
    @Override public void collisionReaction(GameObject collidedWith) {

        if(!InputManager.isPressed(KeyEvent.VK_DOWN)){


            Level1.hasLost = true;



//           Game.destroy();
        }
    }
}
