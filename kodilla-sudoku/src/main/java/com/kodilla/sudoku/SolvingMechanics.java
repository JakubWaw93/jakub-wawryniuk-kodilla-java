package com.kodilla.sudoku;

import java.util.List;

public class SolvingMechanics {

    public SudokuBoard singleLoopSudokuSolver(SudokuBoard sudokuBoard) throws NoPossibleValuesException {
        List<SudokuRow> sudokuBoard1 = sudokuBoard.getSudokuBoard();
        for (int i = 0; i < sudokuBoard1.size(); i++) {
            for (int j = 0; j < sudokuBoard1.get(i).getSudokuRow().size(); j++) {
                SudokuRow sudokuRow = sudokuBoard1.get(i);
                SudokuElement sudokuElement = sudokuRow.getSudokuRow().get(j);
                if (sudokuElement.getValue() == SudokuElement.EMPTY) {
                    for (int k = 0; k < sudokuBoard1.size(); k++) {
                        sudokuElement.getPossibleValues().remove(Integer.valueOf(sudokuRow.getSudokuRow().get(k).getValue()));
                        sudokuElement.getPossibleValues().remove(Integer.valueOf(sudokuBoard1.get(k).getSudokuRow().get(j).getValue()));
                    }
                    if (i < 3) {
                        possibleValuesRemovalFromChosenRowOfSudokuBoxes(0, 3, j, sudokuElement, sudokuBoard1);
                    } else if (i < 6) {
                        possibleValuesRemovalFromChosenRowOfSudokuBoxes(3, 6, j, sudokuElement, sudokuBoard1);
                    } else {
                        possibleValuesRemovalFromChosenRowOfSudokuBoxes(6, 9, j, sudokuElement, sudokuBoard1);
                    }
                    if (sudokuElement.getPossibleValues().size() == 1) {
                        sudokuElement.setValue(sudokuElement.getPossibleValues().get(0));
                    } else if (sudokuElement.getPossibleValues().isEmpty()) {
                        throw new NoPossibleValuesException("No possible values for this field");

                    }
                }
            }
        }
        return sudokuBoard;
    }

    private static void possibleValuesRemovalFromChosenRowOfSudokuBoxes(int l, int x, int j, SudokuElement sudokuElement, List<SudokuRow> sudokuBoard) {
        for (int l1 = l; l1 < x; l1++) {
            possibleValuesRemovalFromRowInChosenBox(j, sudokuElement, sudokuBoard, l1);
        }
    }

    private static void possibleValuesRemovalFromRowInChosenBox(int j, SudokuElement sudokuElement, List<SudokuRow> sudokuBoard, int l) {
        if (j < 3) {
            processPossibleValuesRemovalFromRowInBox(0, 3, sudokuElement, sudokuBoard, l);
        } else if (j < 6) {
            processPossibleValuesRemovalFromRowInBox(3, 6, sudokuElement, sudokuBoard, l);
        } else {
            processPossibleValuesRemovalFromRowInBox(6, 9, sudokuElement, sudokuBoard, l);
        }
    }

    private static void processPossibleValuesRemovalFromRowInBox(int k, int x, SudokuElement sudokuElement, List<SudokuRow> sudokuBoard, int l) {
        for (int k1 = k; k1 < x; k1++) {
            sudokuElement.getPossibleValues().remove(Integer.valueOf(sudokuBoard.get(l).getSudokuRow().get(k1).getValue()));
        }
    }
}