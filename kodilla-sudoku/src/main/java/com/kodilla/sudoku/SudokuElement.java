package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {

    private int value;
    public static final int EMPTY = -1;
    private final List<Integer> possibleValues = new ArrayList<>();

    public SudokuElement(int value) {
        this.value = value;
        possibleValues.add(1);
        possibleValues.add(2);
        possibleValues.add(3);
        possibleValues.add(4);
        possibleValues.add(5);
        possibleValues.add(6);
        possibleValues.add(7);
        possibleValues.add(8);
        possibleValues.add(9);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    @Override
    public String toString() {
        String result;
        if (value == EMPTY) {
            result = " ";
        } else {
            result = String.valueOf(value);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SudokuElement that = (SudokuElement) o;

        if (value != that.value) return false;
        return possibleValues.equals(that.possibleValues);
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + possibleValues.hashCode();
        return result;
    }
}
