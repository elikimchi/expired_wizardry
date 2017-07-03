package com.company;

import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.math.Vec2;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by eli.kimchi on 6/30/2017.
 */
public class Paddle extends GameObject {
    public Vec2 direction = new Vec2(1.0f,0.0f);
    public Paddle() {
        super("Player", 256, 64, "Paddle.png");
        setRectangleCollider(20,20);
    }
    public float movementSpeed = 6.0f;
    public float rotationSpeed = 3.0f;




    @Override
    public void collisionReaction(GameObject collidedWith) {
        //Reset the object's position to 0 , 0
        setPosition(0,0);
        // Change the color to red with 0.5 as opacity
    }

    @Override
    public void update(float dt)
    {
        if(InputManager.isPressed(KeyEvent.VK_LEFT))
        {
            float rotation = getRotation();
            rotation += rotationSpeed;
            setRotation(rotation);
            rotation = (float)Math.toRadians(rotation);
            direction.setX((float)Math.cos(rotation));
            direction.setY((float)Math.sin(rotation));
        }
        if(InputManager.isPressed(KeyEvent.VK_RIGHT))
        {
            float rotation = getRotation();
            rotation -= rotationSpeed;
            setRotation(rotation);
            rotation = (float)Math.toRadians(rotation);
            direction.setX((float)Math.cos(rotation));
            direction.setY((float)Math.sin(rotation));
        }
        if(InputManager.isPressed(KeyEvent.VK_UP)) {
            Vec2 position = getPosition();
            Vec2 movement = new Vec2();
            movement.setX(direction.getX());
            movement.setY(direction.getY());
            movement.scale(movementSpeed * (dt * 40));
            position.add(movement);
            setPosition(position);
        }
        if(InputManager.isPressed(KeyEvent.VK_DOWN)) {
            Vec2 position = getPosition();
            Vec2 movement = new Vec2();
            movement.setX(-direction.getX());
            movement.setY(-direction.getY());
            movement.scale(movementSpeed * (dt * 35));
            position.add(movement);
            setPosition(position);

            }
    }
}