package com.kaminski;

public class Main {

    public static void main(String[] args) {

        Vector2D first = new Vector2D(5, 3);
        Vector2D second = new Vector2D(2, 4);

        Vector2D sum = first.sum(second);
        Vector2D difference = first.dfference(second);

        Vector2D firstNormalized = first.normalize();
        Vector2D secondNormalized = second.normalize();

        double firstLength = first.length();
        double secondLength = second.length();

        Vector2D firstMultiplied = first.multiply(2);

        System.out.println("First : " + first.toString());
        System.out.println("Second : " + second.toString());
        System.out.println("First + Second: " + sum.toString());
        System.out.println("First - Second: " + difference.toString());
        System.out.println("First normalized : " + firstNormalized.toString());
        System.out.println("Second normalized : " + secondNormalized.toString());
        System.out.println("First length : " + firstLength);
        System.out.println("Second length : " + secondLength);
        System.out.println("First multiplied by 2: " + firstMultiplied.toString());
    }

}
