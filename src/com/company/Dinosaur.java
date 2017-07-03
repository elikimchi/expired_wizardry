package com.company;

import edu.digipen.Game;
import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.math.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by jack.notarangelo on 6/30/2017.
 */
public class Dinosaur extends GameObject{
    float ystart;
    float y;
    float up;
    float yjump;
    public static JLabel message = new JLabel("Default Message");

    public Dinosaur() {
        super("Player", 64, 64, "Paddle.png");
        setRectangleCollider(20, 23);
        ystart = getPositionY();
        y = getPositionY();
        up = 0;
        yjump = getPositionY() + 100;
    }
    public float movementSpeed = 6.0f;
    public float rotationSpeed = 3.0f;

    @Override
    public void collisionReaction(GameObject collidedWith) {
        //Reset the object's position to 0 , 0

        setPosition(0,0);
    }

    @Override
    public void update(float dt)
    {
        if ( up == 1 && y < yjump){
            ++y;
            setPositionY(y);
        }
        else if(up == 1 && y == yjump){
            up = 2;
        }
        else if(up == 2 && y > ystart){
            --y;
            setPositionY(y);
        }
        else if(up == 1 && y == ystart){
            up = 0;
        }
        else if(InputManager.isPressed(KeyEvent.VK_UP) || InputManager.isPressed(KeyEvent.VK_SPACE)) {
            up = 1;
            ++y;
            setPositionY(y);

        }
        if(InputManager.isPressed(KeyEvent.VK_DOWN)) {
            setModulationColor(1.0f, 1.0f, 1.0f, 1.0f);
            message.setText("X wins");
           // message.text
        }
    }
}
