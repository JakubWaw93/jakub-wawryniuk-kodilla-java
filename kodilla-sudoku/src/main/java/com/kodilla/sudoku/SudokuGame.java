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

            if (areBoardsTheSame(sudokuBoard, sudokuBoardChangesCheck)) {
                for (int i = 0; i < sudokuBoard.getSudokuBoard().size(); i++) {
                    SudokuRow sudokuRow = sudokuBoard.getSudokuBoard().get(i);
                    for (int j = 0; j < sudokuRow.getSudokuRow().size(); j++) {
                        SudokuElement sudokuElement = sudokuRow.getSudokuRow().get(j);
                        if (sudokuElement.getValue() == SudokuElement.EMPTY) {
                            List<Integer> possibleValues = sudokuElement.getPossibleValues();
                            BackTrack backTrack = new BackTrack(i, j, possibleValues.get(0));
                            backTrack.saveBoardCopy(sudokuBoard);
                            backTracks.add(backTrack);
                            sudokuElement.setValue(possibleValues.get(0));
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
        } catch (NoPossibleValuesException e) {
            SudokuConsole.exceptionMessage(e.getMessage());
             resolveSudoku(reloadSudokuBoard(sudokuBoard));
             return true;
        }
        return false;
    }

    private SudokuBoard reloadSudokuBoard(SudokuBoard sudokuBoard) {
        if (backTracks.size()>0 && !backTracks.get(backTracks.size()-1).getSudokuBoardCopy().getSudokuBoard().isEmpty()) {
            sudokuBoard = backTracks.get(backTracks.size() - 1).getSudokuBoardCopy();
            int i = backTracks.get(backTracks.size() - 1).getiOfGuessingElement();
            int j = backTracks.get(backTracks.size() - 1).getjOfGuessingElement();
            int shootValue = backTracks.get(backTracks.size() - 1).getGuessingValueOfElement();
            sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().remove(Integer.valueOf(shootValue));
            backTracks.remove(backTracks.size() - 1);

        } else {
            SudokuConsole.incorrectSudoku();

        }
        return sudokuBoard;
    }

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
