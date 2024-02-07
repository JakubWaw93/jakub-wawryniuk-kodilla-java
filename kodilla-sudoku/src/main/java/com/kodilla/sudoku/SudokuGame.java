package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuGame {

    private static List<BackTrack> backTracks = new ArrayList<>();


    SolvingMechanics solvingMechanics = new SolvingMechanics();

    public boolean resolveSudoku(SudokuBoard sudokuBoard) {
        BackTrack backTrackForChangesCheck = new BackTrack(0, 0, 0);
        backTrackForChangesCheck.saveBoardCopy(sudokuBoard);
        SudokuBoard sudokuBoardChangesCheck = backTrackForChangesCheck.getSudokuBoardCopy();
        try {
            sudokuBoard = solvingMechanics.singleLoopSudokuSolver(sudokuBoard);
        } catch (NoPossibleValuesException e) {

        }
        if (areBoardsTheSame(sudokuBoard, sudokuBoardChangesCheck)) {
            for (int i = 0; i < sudokuBoard.getSudokuBoard().size(); i++) {
                for (int j = 0; j < sudokuBoard.getSudokuBoard().size(); j++) {
                    if (sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getValue() == SudokuElement.EMPTY) {
                        BackTrack backTrack = new BackTrack(i, j, sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().get(0)); // Dlaczego index out of boundaries?
                        backTrack.saveBoardCopy(sudokuBoard);
                        backTracks.add(backTrack);
                        sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).setValue(sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().get(0));
                        return false;
                    }
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
        return true;
    }
    // jak to zaimplementować? w któym miejscu ?
    /*private boolean reloadSudokuBoard() {
        SudokuBoard sudokuBoard;
        if (!backTracks.get(backTracks.size()-1).getSudokuBoardCopy().getSudokuBoard().isEmpty()) {
            sudokuBoard = backTracks.get(backTracks.size() - 1).getSudokuBoardCopy();
            int i = backTracks.get(backTracks.size() - 1).getiOfGuessingElement();
            int j = backTracks.get(backTracks.size() - 1).getjOfGuessingElement();
            int shootValue = backTracks.get(backTracks.size() - 1).getGuessingValueOfElement();
            sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().remove(Integer.valueOf(shootValue));
            backTracks.remove(backTracks.size() - 1);
            return false;
        } else {
            SudokuConsole.incorrectSudoku();
            return true;
        }
    }*/

    public boolean areBoardsTheSame(SudokuBoard sudokuBoard, SudokuBoard sudokuBoardAfterLoop) {
        List<SudokuElement> sudokuBoardFlatElements = sudokuBoard.getSudokuBoard().stream()
                .flatMap(sudokuRow -> sudokuRow.getSudokuRow().stream())
                .toList();
        List<SudokuElement> sudokuBoardAfterLoopFlatElements = sudokuBoardAfterLoop.getSudokuBoard().stream()
                .flatMap(sudokuRow -> sudokuRow.getSudokuRow().stream())
                .toList();

        return IntStream.range(0, sudokuBoardFlatElements.size())
                .allMatch(i -> sudokuBoardFlatElements.get(i).equals(sudokuBoardAfterLoopFlatElements.get(i)));
    }
}
