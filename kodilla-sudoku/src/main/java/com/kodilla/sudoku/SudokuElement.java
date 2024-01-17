package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {

    private static int value;
    public static int EMPTY = -1;

    private static final List<Integer> elements = new ArrayList<>();

    public SudokuElement(int value) {
        SudokuElement.value = value;
        for (int i = 1; i <= 9; i++) {
            elements.add(i);
        }
    }

}
