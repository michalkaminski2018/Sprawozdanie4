package com.kaminski;

import java.util.TimerTask;

public class SimTask extends TimerTask {

    private SimEngine simEngine;
    private SpringApplet springApplet;
    private int timeInterval;

    public SimTask(SimEngine simEngine, SpringApplet springApplet, int timeInterval) {
        this.simEngine = simEngine;
        this.springApplet = springApplet;
        this.timeInterval = timeInterval;
    }

    @Override
    public void run() {
        simEngine.calculateNewMassPosition();
        springApplet.repaint();
    }
}