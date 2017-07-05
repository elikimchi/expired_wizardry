package com.company;

import edu.digipen.gameobject.GameObject;
import java.util.Random;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.math.Vec2;


/**
 * Created by eli.kimchi on 7/5/2017.
 */
public class Ptero extends GameObject{




        float x;
        Random rand = new Random();
        int  n = rand.nextInt(10000) + 200;

        public Ptero() {
            super("Ptero", 51, 45, "pterospritesheet.png", 2,1,2, 0.7f);
            // super()
            System.out.println(n);
            setRectangleCollider(25, 25);
            setPosition(n, 0);
            x = n;
        }

        @Override
        public void update(float dt) {
            x -= 2;
            setPositionX(x);
        }


}
