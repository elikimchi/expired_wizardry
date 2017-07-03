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

    public Dinosaur() {
        super("Player", 50, 50, "RectangleAnimation.png", 8, 3, 2, 0.1f);
        setRectangleCollider(22, 23);
        ystart = getPositionY();
        y = getPositionY();
        up = 0;
        yjump = getPositionY() + 150;

        i = 0;
    }
    public float movementSpeed = 6.0f;
    public float rotationSpeed = 3.0f;

    @Override
    public void collisionReaction(GameObject collidedWith) {
        while(i == 0){
            }
        }

    @Override
    public void update(float dt)
    {
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
        }
        else if(InputManager.isPressed(KeyEvent.VK_UP) || InputManager.isPressed(KeyEvent.VK_SPACE)) {
            up = 1;
            y += 2;
            setPositionY(y);

        }
        if(InputManager.isPressed(KeyEvent.VK_DOWN)) {
            setRectangleCollider(30, 15);
        }
        else{
            setRectangleCollider(22, 2);
        }
    }
}
