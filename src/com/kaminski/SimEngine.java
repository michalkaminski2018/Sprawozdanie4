package com.kaminski;

public class SimEngine {

    private double mass;
    private double k;
    private double c;
    private double springLength;
    private Vector2D massPosition;
    private double massSpeed;
    private Vector2D suspensionPoint;
    private double g = 9.81;
    private double massAcceleration;

    private double temp = 0;

    private double time = 0.3;

    public SimEngine(double mass, double k, double c, double springLength, Vector2D massPosition, double massSpeed, Vector2D suspensionPoint, double g, double massAcceleration) {
        this.mass = mass;
        this.k = k;
        this.c = c;
        this.springLength = springLength;
        this.massPosition = massPosition;
        this.massSpeed = massSpeed;
        this.suspensionPoint = suspensionPoint;
        this.g = g;
        this.massAcceleration = massAcceleration;
    }

    public void calculateNewMassPosition() {
        massAcceleration = g - (k * massPosition.y / mass) - (c * massSpeed / mass);
        massSpeed = massSpeed + massAcceleration * time;
        temp = temp + massSpeed * time + (massAcceleration * Math.pow(time, 2)) / 2;
        massPosition.y = temp;
    }

    public void resetSimulation() {
        massSpeed = 0;
        time = 0;
    }

    public double getMass() {
        return mass;
    }

    public boolean setMass(double mass) {
        if (mass > 0) {
            this.mass = mass;
            return true;
        }
        return false;
    }

    public double getK() {
        return k;
    }

    public boolean setElasticityFactor(double elasticityFactor) {
        if (elasticityFactor > 0) {
            this.k = elasticityFactor;
            return true;
        }
        return false;
    }

    public double getC() {
        return c;
    }

    public boolean setDampingFactor(double dampingFactor) {
        if (dampingFactor > 0) {
            this.c = dampingFactor;
            return true;
        }
        return false;
    }

    public double getSpringLength() {
        return springLength;
    }

    public boolean setSpringLength(double springLength) {
        if (springLength > 0) {
            this.springLength = springLength;
            return true;
        }
        return false;
    }

    public Vector2D getMassPosition() {
        return massPosition;
    }

    public boolean setMassPosition(Vector2D massPosition) {
        if (massPosition != null) {
            this.massPosition = massPosition;
            return true;
        }
        return false;
    }

    public double getMassSpeed() {
        return massSpeed;
    }

    public boolean setMassSpeed(double massSpeed) {
        if (massSpeed >= 0) {
            this.massSpeed = massSpeed;
            return true;
        }
        return false;
    }

    public Vector2D getSuspensionPoint() {
        return suspensionPoint;
    }

    public boolean setSuspensionPoint(Vector2D suspensionPoint) {
        if (suspensionPoint != null) {
            this.suspensionPoint = suspensionPoint;
            return true;
        }
        return false;
    }

    public double getGravitationalAcceleration() {
        return g;
    }

    public boolean setGravitationalAcceleration(double gravitationalAcceleration) {
        if (gravitationalAcceleration > 0) {
            this.g = gravitationalAcceleration;
            return true;
        }
        return false;
    }
}
