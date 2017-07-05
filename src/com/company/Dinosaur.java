package com.company;

import edu.digipen.Game;
import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.math.Vec2;

import javax.swing.*;
import java.awt.*;
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
        setPosition(0,-5);
        setRectangleCollider(18, 23);
        ystart = getPositionY();
        y = getPositionY();
        up = 0;
        yjump = getPositionY() + 150;
        run = 0;

        i = 0;
    }
    public float movementSpeed = 6.0f;
    public float rotationSpeed = 3.0f;

    @Override
    public void collisionReaction(GameObject collidedWith) {
        animationData.goToAndStop(3);
        while(i == 0){
            }
        }

    @Override
    public void update(float dt)
    {

//        if(run == 0){
//            animationData.goToAndStop(run);
//            run = 1;
//        }
//        else if(run == 1){
//            animationData.goToAndStop(run);
//            run = 0;
//        }
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
            y += 2;
            setPositionY(y);
        }
        else if(up == 1 && y == yjump){
            up = 2;
        }
        else if(up == 2 && y > ystart){
            y -= 2;
            setPositionY(y);
        }
        else if(up == 1 && y == ystart){
            up = 0;
            run = 0;

        }
        else if(InputManager.isPressed(KeyEvent.VK_UP) || InputManager.isPressed(KeyEvent.VK_SPACE)) {
            up = 1;
            y += 2;
            setPositionY(y);
            animationData.goToAndStop(2);
            run = 2;
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
            setRectangleCollider(20, 23);
        }
    }
}
