package com.kodilla.sudoku;

public class SudokuRunner {

    public static void main(String[] args) {

        SudokuBoard sudokuBoard = new SudokuBoard();
        boolean gameFinished = false;
        SudokuBoardCreator sudokuBoardCreator = new SudokuBoardCreator();
        sudokuBoard = sudokuBoardCreator.setVisibleNumbers(sudokuBoard);
        while (!gameFinished) {
            SudokuGame game = new SudokuGame();
            gameFinished = game.resolveSudoku(sudokuBoard);
        }
        SudokuConsole.showSudokuBoard(sudokuBoard);
    }

}
