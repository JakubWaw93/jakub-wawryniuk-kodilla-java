package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> listOfFigures;

    public ShapeCollector() {
        listOfFigures = new ArrayList<>();
    }

    public ArrayList<Shape> getListOfFigures() {
        return listOfFigures;
    }
    public int getSizeOfList(){
        return listOfFigures.size();
    }

    public void addFigure(Shape shape){
        listOfFigures.add(shape);
    }

    public void removeFigure(Shape shape){
        listOfFigures.remove(shape);
    }

    public Shape getFigure(int n){
        Shape tempShape = listOfFigures.get(n);
        return tempShape;
    }

    public ArrayList<Shape> showFigures(){
        return listOfFigures;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShapeCollector collector = (ShapeCollector) o;

        return listOfFigures.equals(collector.listOfFigures);
    }

    @Override
    public int hashCode() {
        return listOfFigures.hashCode();
    }
}
