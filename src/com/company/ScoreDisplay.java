package com.company;

import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;

/**
 * Created by eli.kimchi on 7/6/2017.
 */
public class ScoreDisplay {

    GameObject[] numberObjects;

    public ScoreDisplay(int scale, int spacing, int x, int y)
    {
        numberObjects = new GameObject[5];
        for(int i = 0; i < 5; ++ i) {
            numberObjects[i] = new GameObject("Name", scale, scale, "numberspritesheet.png", 10, 1, 10, 0);
            numberObjects[i].goToAndStop(0);
            ObjectManager.addGameObject(numberObjects[i]);
            numberObjects[i].setPosition(i * spacing + x, y);
        }
    }

    public void displayNumber(int num)
    {
        char[] digits = turnDigitIntoString(num).toCharArray();
        for(int i = 0; i < digits.length; ++i)
        {
            numberObjects[i + (numberObjects.length - digits.length)].goToAndStop(characterToFromNumber(digits[i]));
        }
    }

    void KillObjects()
    {
        for(int i = 0; i < numberObjects.length; ++i)
        {
            numberObjects[i].kill();
        }
    }

    private String turnDigitIntoString(int num)
    {
        return "" + num;
    }

    private int characterToFromNumber(char digit)
    {
        return (digit - '0');
    }
}
