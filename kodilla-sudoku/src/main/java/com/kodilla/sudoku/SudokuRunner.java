package com.kodilla.sudoku;

public class SudokuRunner {

    public static void main(String[] args) throws WrongCommendException, IncorrectSudokuException {
        boolean end = false;
        while (!end) {
            SudokuBoard sudokuBoard = new SudokuBoard();
            SudokuBoardCreator.setVisibleNumbers(sudokuBoard);
            SudokuGame game = new SudokuGame();
            game.resolveSudoku(sudokuBoard);
            SudokuConsole.showSudokuBoard(sudokuBoard);
            end = SudokuBoardCreator.isSolvingEnd(end);
        }
    }
}
