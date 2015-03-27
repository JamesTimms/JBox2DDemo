package org.main;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;

/**
 * Created by TekMaTek on 27/03/2015.
 */
public class test {

    public static void main(String[] args) {
        Vec2 gravity = new Vec2(0.0f, -10.0f);
        World world = new World(gravity);
        BodyDef ground = new BodyDef();
        ground.position.set(0.0f, -10.0f);
        Body myBody = world.createBody(ground);

        PolygonShape groundBox = new PolygonShape();
        groundBox.setAsBox(50.0f, 10.0f);
        myBody.createFixture(groundBox, 0.0f);

        BodyDef dynamic = new BodyDef();
        dynamic.type = BodyType.DYNAMIC;
        dynamic.position.set(0.0f, 4.0f);
        Body bodyD = world.createBody(dynamic);

        PolygonShape boxD = new PolygonShape();
        boxD.setAsBox(1.0f, 1.0f);
        FixtureDef fix = new FixtureDef();
        fix.shape = boxD;
        fix.density = 1.0f;
        fix.friction = 0.3f;
        bodyD.createFixture(fix);

        float timeStep = 1.0f / 60.0f;
        int velocityIterations = 6;
        int positionIterations = 2;

        for(int i = 0; i < 60; ++i) {
            world.step(timeStep, velocityIterations, positionIterations);
            Vec2 position = bodyD.getPosition();
            float angle = bodyD.getAngle();
            System.out.println(position.toString() + " " + angle);
        }
    }

}
