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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(side, triangle.side) != 0) return false;
        return Double.compare(height, triangle.height) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(side);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
