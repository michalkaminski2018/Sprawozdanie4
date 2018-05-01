package com.kaminski;

public class Vector2D {

    public double x;
    public double y;

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D sum(Vector2D otherVector) {
        double newX = this.x + otherVector.x;
        double newY = this.y + otherVector.y;
        return new Vector2D(newX, newY);
    }

    public Vector2D dfference(Vector2D otherVector) {
        double newX = this.x - otherVector.x;
        double newY = this.y - otherVector.y;
        return new Vector2D(newX, newY);
    }

    public Vector2D multiply(int number) {
        double newX = this.x * number;
        double newY = this.y * number;
        return new Vector2D(newX, newY);
    }

    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public Vector2D normalize() {
        double length = length();
        int newX = (int) (this.x / length);
        int newY = (int) (this.y / length);
        return new Vector2D(newX, newY);
    }

    @Override
    public String toString() {
        return "Vector(" + x + ", " + y + ")";
    }
}