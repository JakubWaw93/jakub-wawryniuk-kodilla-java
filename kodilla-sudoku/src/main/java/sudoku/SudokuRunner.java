package sudoku;

public class SudokuRunner {

    public static void main(String[] args) {
        boolean gameFinished = false;
        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuBoardCreator sudokuBoardCreator = new SudokuBoardCreator();
        int howManyNumbers = sudokuBoardCreator.howManyElements();
        sudokuBoard = sudokuBoardCreator.setOneVisibleNumber(howManyNumbers, sudokuBoard);
        /*while (!gameFinished) {
            SudokuGame game = new SudokuGame();
            gameFinished = game.resolveSudoku(sudokuBoard);
        }*/
        SudokuConsole.showResolvedSudokuBoard(sudokuBoard);
    }

}
