package com.company;

import edu.digipen.gameobject.GameObject;
import java.util.Random;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.math.Vec2;


/**
 * Created by eli.kimchi on 7/5/2017.
 */
public class Ptero extends GameObject{

    public float idleTimer;
    public float idleFrameDelay = 0.3f;
    public boolean idleToggle = false;

    float y;
    float x;
    Random rand = new Random();
    int  n = rand.nextInt(3) + 1;

    public Ptero() {
        super("Ptero", 51, 45, "pterospritesheet.png", 2,1,2, 0.7f);
        setRectangleCollider(20, 14);
        x = 600.0f;
        if (n == 1){
            y = -7;
        }
        else if (n == 2){
            y = 16;
        }
        else if(n == 3){
            y = 40;
        }
        setPosition(x, y);
    }

        @Override
        public void update(float dt) {
            x -= 3 + Level1.score / 500;
            if(x < -1000){
                kill();
            }

            if(!Level1.hasLost)
                setPositionX(x);

            if(idleTimer <= 0.0f)
            {
                idleToggle = !idleToggle;
                idleTimer = idleFrameDelay;
            }
            else
                idleTimer -= dt;

            if(idleToggle)
                goToAndStop(0);
            else
                goToAndStop(1);
            animationData.play();

        }


}
