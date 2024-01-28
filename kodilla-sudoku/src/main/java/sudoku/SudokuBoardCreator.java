package sudoku;

public class SudokuBoardCreator {

    public int howManyElements() {
        return SudokuConsole.howManyNumbers();
    }

    public SudokuBoard setVisibleNumbers(int howManyNumbers, SudokuBoard sudokuBoard) {
        int line = 0;
        int element = 0;
        int number = SudokuElement.EMPTY;
        String userChoice;
        for (int i = 0; i < howManyNumbers; i++) {
            userChoice = SudokuConsole.chooseAnElementAndNumber();
            line = (Integer.parseInt(userChoice.substring(0, 1)))-1;
            element = (Integer.parseInt(userChoice.substring(1, 2)))-1;
            number = Integer.parseInt(userChoice.substring(2));
            sudokuBoard.getSudokuBoard().get(line).getSudokuRow().get(element).setValue(number);
        }
        return sudokuBoard;
    }




}
