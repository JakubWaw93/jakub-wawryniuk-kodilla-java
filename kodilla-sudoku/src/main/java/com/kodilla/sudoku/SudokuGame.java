package com.kodilla.sudoku;

public class SudokuGame {

    public boolean resolveSudoku(SudokuBoard sudokuBoard) {
        SolvingMechanics solvingMechanics = new SolvingMechanics();
        solvingMechanics.sudokuCheck(sudokuBoard);
        int emptyFields = 0;
        for (int i = 0; i < sudokuBoard.getSudokuBoard().size(); i++) {
            for (int j = 0; j < sudokuBoard.getSudokuBoard().size(); j++) {
                if (sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getValue() == SudokuElement.EMPTY) {
                    emptyFields++;
                }
            }
        }
        if (emptyFields > 0) {
            return false;
        } else {
            return true;
        }
    }
}
