package com.kaminski;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;

public class SpringApplet extends JApplet {

    private int windowWidth = 300;
    private int windowHeight = 500;

    private SimEngine simEngine;
    private SimTask simTask;
    private Timer timer;

    private int beginningMass = 30;
    private double beginningK = 3;
    private double beginningC = 0.2;
    private double beginningGravitationalAcceleration = 9.81;
    private int beginningSpringLength = 30;
    private double massAcceleration = 0;

    @Override
    public void init() {
        this.setSize(windowWidth, windowHeight);

        Vector2D beginningMassPosition = new Vector2D(getSize().width / 2, 150 + 20);
        Vector2D suspensionPoint = new Vector2D(getSize().width / 2, 50);
        simEngine = new SimEngine(beginningMass, beginningK, beginningC, beginningSpringLength,
                beginningMassPosition, 25, suspensionPoint, beginningGravitationalAcceleration, massAcceleration);
        simTask = new SimTask(simEngine, this, 1);
        timer = new Timer();
        timer.scheduleAtFixedRate(simTask, 0, 10);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        graphics.setColor(Color.black);

        printSpring(graphics);
        printMass(graphics);
    }

    private void printSpring(Graphics graphics) {
        Vector2D suspensionPoint = simEngine.getSuspensionPoint();
        Vector2D massPosition = simEngine.getMassPosition();
        graphics.drawLine((int)suspensionPoint.x, (int)suspensionPoint.y, (int)massPosition.x, (int)massPosition.y + 100);
        graphics.drawLine((int)suspensionPoint.x, (int)suspensionPoint.y, (int)massPosition.x, (int)massPosition.y + 100);

        graphics.drawLine((int)suspensionPoint.x - 30, (int)suspensionPoint.y, (int)suspensionPoint.x + 30, (int)suspensionPoint.y);

        graphics.drawLine((int)suspensionPoint.x - 30, (int)suspensionPoint.y, (int)suspensionPoint.x - 20, (int)suspensionPoint.y - 10);
        graphics.drawLine((int)suspensionPoint.x - 20, (int)suspensionPoint.y, (int)suspensionPoint.x - 10, (int)suspensionPoint.y - 10);
        graphics.drawLine((int)suspensionPoint.x - 10, (int)suspensionPoint.y, (int)suspensionPoint.x, (int)suspensionPoint.y - 10);
        graphics.drawLine((int)suspensionPoint.x, (int)suspensionPoint.y, (int)suspensionPoint.x + 10, (int)suspensionPoint.y - 10);
        graphics.drawLine((int)suspensionPoint.x + 10, (int)suspensionPoint.y, (int)suspensionPoint.x + 20, (int)suspensionPoint.y - 10);
        graphics.drawLine((int)suspensionPoint.x + 20, (int)suspensionPoint.y, (int)suspensionPoint.x + 30, (int)suspensionPoint.y - 10);
    }

    private void printMass(Graphics graphics) {
        Vector2D massPosition = simEngine.getMassPosition();
        graphics.drawOval((int)massPosition.x - 10, (int)massPosition.y + 100, 20, 10);
    }
}