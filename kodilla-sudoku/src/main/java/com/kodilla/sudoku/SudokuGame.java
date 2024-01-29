package com.kodilla.sudoku;

public class SudokuGame {

    private BackTrack backTrack;
    private final CorrectNumbersCheck correctNumbersCheck = new CorrectNumbersCheck();

    public boolean resolveSudoku(SudokuBoard sudokuBoard) {
        SolvingMechanics solvingMechanics = new SolvingMechanics();
        SudokuBoard nextLoopSudokuBoard = solvingMechanics.singleLoopSudokuSolver(sudokuBoard);
        boolean firstCopy = true;
        while (firstCopy) {
            if (sudokuBoard.equals(nextLoopSudokuBoard)) {
                for (int i = 0; i < sudokuBoard.getSudokuBoard().size(); i++) {
                    for (int j = 0; j < sudokuBoard.getSudokuBoard().size(); j++) {
                        if (sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getValue() == SudokuElement.EMPTY) {
                            backTrack = new BackTrack(i, j, sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getValue());
                            backTrack.saveBoardCopy(sudokuBoard);
                            sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).setValue(sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().get(0));
                            firstCopy = false;
                        }
                    }
                }
                for (SudokuRow sudokuRow : sudokuBoard.getSudokuBoard()) {
                    for (SudokuElement sudokuElement : sudokuRow.getSudokuRow()) {
                        if (sudokuElement.getValue() == SudokuElement.EMPTY) {
                            return false;
                        }
                    }
                }
            }
        }
//        if (!correctNumbersCheck.checkSudoku(sudokuBoard)) {
//            sudokuBoard = backTrack.getSudokuBoardCopy();
//            sudokuBoard.getSudokuBoard().get(backTrack.getiOfGuessingElement()).getSudokuRow().get(backTrack.getjOfGuessingElement()).getPossibleValues().remove(Integer.valueOf(backTrack.getGuessingValueOfElement()));
//            firstCopy = true;
//            return false;
//        }
        return true;
    }//sprawdzic czy dziala  backTrack i correctNumbersCheck
}
