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

    }

    public Shape getFigure(int n){

        return null;
    }

    public ArrayList<Shape> showFigures(){
        return null;

    }
}
