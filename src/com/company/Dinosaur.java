package com.company;

import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;

import java.awt.event.KeyEvent;

public class Dinosaur extends GameObject{
    float ystart;
    float y;
    float up;
    float yjump;
    int i;
    int run;

    public float idleTimer;
    public float idleFrameDelay = 0.3f;
    public boolean idleToggle = false;
    private boolean isJumping = false;

    private float jumpDelayTimer = 0.1f;


    public Dinosaur() {
        super("Player", 61, 47, "dinospritesheet.png", 6, 1, 6, 0.7f);
        setPosition(-250,-5);
        setRectangleCollider(18, 23);
        ystart = getPositionY();
        y = getPositionY();
        up = 0;
        yjump = getPositionY() + 129;
        run = 0;

        i = 0;
    }

    @Override
    public void collisionReaction(GameObject collidedWith) {
        animationData.goToAndStop(3);
        while(!InputManager.isPressed(KeyEvent.VK_UP) || !InputManager.isPressed(KeyEvent.VK_SPACE)){
        }
    }

    @Override
    public void update(float dt)
    {
        if(isJumping)
        {
            if(jumpDelayTimer <= 0.0f)
            {
                if(getPositionY() <= ystart + 3 && getPositionY() >= ystart -3)
                {
                    isJumping = false;
                }
            }
            else
                jumpDelayTimer -= dt;
        }



        if(isJumping == false)
        {
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


        if ( up == 1 && y < yjump){
            y += 3;
            setPositionY(y);
        }
        else if(up == 1 && y == yjump){
            up = 2;
        }
        else if(up == 2 && y > ystart){
            y -= 3;
            setPositionY(y);
        }
        else if(up == 1 && y == ystart){
            up = 0;

        }
        else if(InputManager.isPressed(KeyEvent.VK_UP) || InputManager.isPressed(KeyEvent.VK_SPACE)) {
            up = 1;
            y += 3;
            setPositionY(y);
            animationData.goToAndStop(2);
            isJumping = true;
            jumpDelayTimer = 0.1f;
        }
        if(InputManager.isPressed(KeyEvent.VK_DOWN)) {
            setRectangleCollider(30, 15);
            if(idleTimer <= 0.0f)
            {
                idleToggle = !idleToggle;
                idleTimer = idleFrameDelay;
            }
            else
                idleTimer -= dt;

            if(idleToggle)
                goToAndStop(4);
            else
                goToAndStop(5);

            animationData.play();

            y  = ystart;
            setPositionY(y);
        }
        else{
            setRectangleCollider(18, 23);
        }
    }
}
