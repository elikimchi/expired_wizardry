package com.company;

        import edu.digipen.gameobject.GameObject;
        import edu.digipen.gameobject.ObjectManager;
        import edu.digipen.math.Vec2;

public class Enemy extends GameObject {

    public Enemy() {
        super("Enemy", 75, 75, "Ball.png");
        setPosition(200, 200);
    }

    @Override
    public void update(float dt) {
        GameObject player = ObjectManager.getGameObjectByName("Player");
        Vec2 vector = new Vec2();

        vector.setX(player.getPositionX() - getPositionX());
        vector.setY(player.getPositionY() - getPositionY());

        vector.normalize();
        vector.scale(dt * 115);

        setPositionX(getPositionX() + vector.getX());
        setPositionY(getPositionY() + vector.getY());
    }
}