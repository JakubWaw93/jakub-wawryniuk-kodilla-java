package sudoku;

public class SolvingMechanics {

    public void sudokuCheck(SudokuBoard sudokuBoard) {
        for (int i = 1; i < sudokuBoard.getSudokuBoard().size(); i++) {
            for (int j = 0; j < sudokuBoard.getSudokuBoard().size(); j++) {
                if (sudokuBoard.getSudokuBoard().get(i).getSudokuRow().get(j).getValue() == SudokuElement.EMPTY) {

    }

}
