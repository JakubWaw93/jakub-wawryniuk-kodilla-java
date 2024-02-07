package com.kodilla.sudoku;

public class BackTrack {

    private SudokuBoard sudokuBoardCopy;
    private final int iOfGuessingElement;
    private final int jOfGuessingElement;
    private final int guessingValueOfElement;


    public BackTrack(int iOfGuessingElement, int jOfGuessingElement, int guessingValueOfElement) {
        this.iOfGuessingElement = iOfGuessingElement;
        this.jOfGuessingElement = jOfGuessingElement;
        this.guessingValueOfElement = guessingValueOfElement;

    }

    public void saveBoardCopy(SudokuBoard sudokuBoard) {
        try {
            sudokuBoardCopy = sudokuBoard.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
    }

    public SudokuBoard getSudokuBoardCopy() {
        return sudokuBoardCopy;
    }

    public int getiOfGuessingElement() {
        return iOfGuessingElement;
    }

    public int getjOfGuessingElement() {
        return jOfGuessingElement;
    }

    public int getGuessingValueOfElement() {
        return guessingValueOfElement;
    }


}
