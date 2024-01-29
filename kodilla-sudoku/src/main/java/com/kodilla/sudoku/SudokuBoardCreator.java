package com.kodilla.sudoku;

import java.util.Objects;

public class SudokuBoardCreator {

    public SudokuBoard setVisibleNumbers(SudokuBoard sudokuBoard) {
        int line = 0;
        int element = 0;
        int number = SudokuElement.EMPTY;
        String userChoice;
        boolean sudokuBoardCreated = false;
        while (!sudokuBoardCreated) {
            userChoice = SudokuConsole.chooseAnElementAndNumber();
            if (Objects.equals(userChoice, "x")) {
                sudokuBoardCreated = true;
            } else {
                line = (Integer.parseInt(userChoice.substring(0, 1))) - 1;
                element = (Integer.parseInt(userChoice.substring(1, 2))) - 1;
                number = Integer.parseInt(userChoice.substring(2));
                sudokuBoard.getSudokuBoard().get(line).getSudokuRow().get(element).setValue(number);
                SudokuConsole.showSudokuBoard(sudokuBoard);
            }
        }
    return sudokuBoard;
    }
}
