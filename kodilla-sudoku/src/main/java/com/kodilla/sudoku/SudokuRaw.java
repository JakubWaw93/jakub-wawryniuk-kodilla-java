package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRaw {

    //private SudokuElement sudokuElement;
    private List<SudokuElement> sudokuRaw = new ArrayList<>();

    public SudokuRaw() {
        for (int i = 0; i < SudokuBoard.sudokuSize; i++) {
            sudokuRaw.add(new SudokuElement(SudokuElement.EMPTY));
        }
    }

    public List<SudokuElement> getSudokuRaw() {
        return sudokuRaw;
    }
}
