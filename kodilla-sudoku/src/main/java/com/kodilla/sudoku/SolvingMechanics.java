package com.kodilla.sudoku;

public class SolvingMechanics {

    public SudokuBoard sudokuCheck(SudokuBoard sudokuBoard) {
        for (int i = 0; i < sudokuBoard.getSudokuBoard().size(); i++) {
            for (int j = 0; j < sudokuBoard.getSudokuBoard().size(); j++) {
                if (sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getValue() == SudokuElement.EMPTY) {
                    for (int k = 0; k < sudokuBoard.getSudokuBoard().size(); k++) {
                        sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().remove(Integer.valueOf(sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(k).getValue()));
                    }
                    for (int l = 0; l < sudokuBoard.getSudokuBoard().size(); l++) {
                        sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().remove(Integer.valueOf(sudokuBoard.getSudokuBoard().get(l).getSudokuRow().get(j).getValue()));
                    }
                    if (i < 3) {
                        for (int l1 = 0; l1 < 3; l1++) {
                            if (j < 3) {
                                for (int k1 = 0; k1 < 3; k1++) {
                                    sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().remove(Integer.valueOf(sudokuBoard.getSudokuBoard().get(l1).getSudokuRow().get(k1).getValue()));
                                }
                            } else if (j > 2 && j < 6) {
                                for (int k2 = 3; k2 < 6; k2++) {
                                    sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().remove(Integer.valueOf(sudokuBoard.getSudokuBoard().get(l1).getSudokuRow().get(k2).getValue()));
                                }
                            } else if (j > 5) {
                                for (int k3 = 6; k3 < 9; k3++) {
                                    sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().remove(Integer.valueOf(sudokuBoard.getSudokuBoard().get(l1).getSudokuRow().get(k3).getValue()));
                                }
                            }
                        }

                    } else if (i > 2 && i < 6) {
                        for (int l2 = 3; l2 < 6; l2++) {
                            if (j < 3) {
                                for (int k4 = 0; k4 < 3; k4++) {
                                    sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().remove(Integer.valueOf(sudokuBoard.getSudokuBoard().get(l2).getSudokuRow().get(k4).getValue()));
                                }
                            } else if (j > 2 && j < 6) {
                                for (int k5 = 3; k5 < 6; k5++) {
                                    sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().remove(Integer.valueOf(sudokuBoard.getSudokuBoard().get(l2).getSudokuRow().get(k5).getValue()));
                                }
                            } else if (j > 5) {
                                for (int k6 = 6; k6 < 9; k6++) {
                                    sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().remove(Integer.valueOf(sudokuBoard.getSudokuBoard().get(l2).getSudokuRow().get(k6).getValue()));
                                }
                            }
                        }
                    } else if (i > 5) {
                        for (int l3 = 6; l3 < 9; l3++) {
                            if (j < 3) {
                                for (int k7 = 0; k7 < 3; k7++) {
                                    sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().remove(Integer.valueOf(sudokuBoard.getSudokuBoard().get(l3).getSudokuRow().get(k7).getValue()));
                                }
                            } else if (j > 2 && j < 6) {
                                for (int k8 = 3; k8 < 6; k8++) {
                                    sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().remove(Integer.valueOf(sudokuBoard.getSudokuBoard().get(l3).getSudokuRow().get(k8).getValue()));
                                }
                            } else if (j > 5) {
                                for (int k9 = 6; k9 < 9; k9++) {
                                    sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().remove(Integer.valueOf(sudokuBoard.getSudokuBoard().get(l3).getSudokuRow().get(k9).getValue()));
                                }
                            }
                        }
                    }
                    if (sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().size() == 1) {
                        sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).setValue(sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getPossibleValues().get(0));
                    }
                }
            }
        }
        return sudokuBoard;
    }
}