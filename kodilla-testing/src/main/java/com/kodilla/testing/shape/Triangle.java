package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private double side;
    private double height;

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getField() {
        return 0.5 * side * height;
    }
}
