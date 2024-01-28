package sudoku;

public class SudokuRunner {

    public static void main(String[] args) {
        boolean gameFinished = false;
        SudokuBoardCreator sudokuBoardCreator = new SudokuBoardCreator();
        int howManyNumbers = sudokuBoardCreator.howManyElements();
        SudokuBoard sudokuBoard = sudokuBoardCreator.setVisibleNumbers(howManyNumbers,new SudokuBoard());
        while (!gameFinished) {
            SudokuGame game = new SudokuGame();
            gameFinished = game.resolveSudoku(sudokuBoard);
        }
        SudokuConsole.showResolvedSudokuBoard(sudokuBoard);
    }

}
