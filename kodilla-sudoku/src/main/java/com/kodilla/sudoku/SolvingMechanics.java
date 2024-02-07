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
                        ProcessPossibleValuesRemovalSudokuBox(0, 3, j, sudokuElement, sudokuBoard1);
                    } else if (i > 2 && i < 6) {
                        ProcessPossibleValuesRemovalSudokuBox(3, 6, j, sudokuElement, sudokuBoard1);
                    } else if (i > 5) {
                        ProcessPossibleValuesRemovalSudokuBox(6, 9, j, sudokuElement, sudokuBoard1);
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

    private static void ProcessPossibleValuesRemovalSudokuBox(int l, int x, int j, SudokuElement sudokuElement, List<SudokuRow> sudokuBoard1) {
        for (int l1 = l; l1 < x; l1++) {
            processPossibleValuesRemovalCombine(j, sudokuElement, sudokuBoard1, l1);
        }
    }

    private static void processPossibleValuesRemovalCombine(int j, SudokuElement sudokuElement, List<SudokuRow> sudokuBoard1, int l1) {
        if (j < 3) {
            processPossibleValuesRemoving(0, 3, sudokuElement, sudokuBoard1, l1);
        } else if (j > 2 && j < 6) {
            processPossibleValuesRemoving(3, 6, sudokuElement, sudokuBoard1, l1);
        } else if (j > 5) {
            processPossibleValuesRemoving(6, 9, sudokuElement, sudokuBoard1, l1);
        }
    }

    private static void processPossibleValuesRemoving(int k, int x, SudokuElement sudokuElement, List<SudokuRow> sudokuBoard1, int l1) {
        for (int k1 = k; k1 < x; k1++) {
            sudokuElement.getPossibleValues().remove(Integer.valueOf(sudokuBoard1.get(l1).getSudokuRow().get(k1).getValue()));
        }
    }
}