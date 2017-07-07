package com.company;

import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.math.Vec2;
import java.util.Random;
import java.util.logging.Level;

public class Cactus extends GameObject{

    float x;
    Random rand = new Random();
    int  n = rand.nextInt(10000) + 200;
    int type;

    public Cactus() {
        super("Cactus", 61, 50, "cactusspritesheet.png", 4, 1, 4, 0.7f);
       // super()
        x = 600.0f;
        setPositionX(x);
        type = rand.nextInt(4);
        animationData.goToFrame(type);


        if (type == 0){
            setRectangleCollider(24, 17);
            setPositionY(-10);
        }
        else if (type == 1){
            setRectangleCollider(13, 23);
            setPositionY(-3); // done
        }
        else if (type == 2){
            setRectangleCollider(17, 17);
            setPositionY(-10);
        }
        else if (type == 3){
            setRectangleCollider(9, 17);
            setPositionY(-10);
        }
    }

        @Override
    public void update(float dt) {
            if(!Level1.hasLost)
            {
                x -= 3 + Level1.score / 500;
                setPositionX(x);
            }
    }
}
