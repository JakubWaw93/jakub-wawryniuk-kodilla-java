package com.kodilla.sudoku;

import java.util.List;
import java.util.stream.Collectors;

public class CorrectNumbersCheck {

    public boolean checkSudoku(SudokuBoard sudokuBoard) {

        for (int i = 0; i < sudokuBoard.getSudokuBoard().size(); i++) {
            int rowIndex = i;
            List<Integer> noDuplicatesRow = sudokuBoard.getSudokuBoard().get(i).getSudokuRow().stream()
                    .map(SudokuElement::getValue)
                    .distinct()
                    .toList();
            if (noDuplicatesRow.size() < sudokuBoard.getSudokuBoard().size()) {
                return false;
            }
            List<Integer> noDuplicatesColumn = sudokuBoard.getSudokuBoard().stream()
                    .map(n -> n.getSudokuRow()
                            .get(rowIndex).getValue())
                    .distinct()
                    .toList();
            if (noDuplicatesColumn.size() < sudokuBoard.getSudokuBoard().size()) {
                return false;
            }
        }
        return true;
    }
}
