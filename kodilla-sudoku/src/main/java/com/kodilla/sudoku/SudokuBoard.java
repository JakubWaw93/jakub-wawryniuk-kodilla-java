package com.kodilla.sudoku;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    private List<SudokuRaw> sudokuBoard = new ArrayList<>();
    private int [][] smallSudoku = new int [3][3];
    private Array [][] bigArray = new Array[3][3];
    public static final int sudokuSize = 9;

    public SudokuBoard() {
        for (int i = 0; i < sudokuSize; i++) {
            sudokuBoard.add(new SudokuRaw());
        }
    }
}
