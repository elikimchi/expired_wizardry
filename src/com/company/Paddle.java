package com.company;

import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.math.Vec2;

import java.awt.event.KeyEvent;

/**
 * Created by eli.kimchi on 6/30/2017.
 */
public class Paddle extends GameObject {
    public Vec2 direction = new Vec2(1.0f,0.0f);
    public Paddle() {
        super("Object1", 256, 64, "Paddle.png");
    }
    public float movementSpeed = 6.0f;
    public float rotationSpeed = 3.0f;
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
            position.setX(position.getX() + direction.getX() * movementSpeed);
            position.setY(position.getY() + direction.getY() * movementSpeed);
            setPosition(position);
        }
        if(InputManager.isPressed(KeyEvent.VK_DOWN)) {
            Vec2 position = getPosition();
            position.setX(position.getX() - direction.getX() * movementSpeed);
            position.setY(position.getY() - direction.getY() * movementSpeed);
            setPosition(position);
            }
    }
}
