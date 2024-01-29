package com.kodilla.sudoku;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SudokuTestSuite {

    static SolvingMechanics solvingMechanics;
    static SudokuBoard sudokuBoard;
    static SudokuGame sudokuGame;
    @BeforeAll
    static void createABoard() {
        solvingMechanics = new SolvingMechanics();
        sudokuBoard = new SudokuBoard();
        sudokuBoard.getSudokuBoard().get(0).getSudokuRow().get(7).setValue(7);
        sudokuBoard.getSudokuBoard().get(6).getSudokuRow().get(6).setValue(4);
        sudokuBoard.getSudokuBoard().get(0).getSudokuRow().get(8).setValue(3);
        sudokuBoard.getSudokuBoard().get(1).getSudokuRow().get(1).setValue(8);
        sudokuBoard.getSudokuBoard().get(1).getSudokuRow().get(3).setValue(6);
        sudokuBoard.getSudokuBoard().get(1).getSudokuRow().get(6).setValue(5);
        sudokuBoard.getSudokuBoard().get(2).getSudokuRow().get(1).setValue(1);
        sudokuBoard.getSudokuBoard().get(2).getSudokuRow().get(5).setValue(7);
        sudokuBoard.getSudokuBoard().get(2).getSudokuRow().get(6).setValue(8);
        sudokuBoard.getSudokuBoard().get(2).getSudokuRow().get(0).setValue(2);
        sudokuBoard.getSudokuBoard().get(2).getSudokuRow().get(2).setValue(3);
        sudokuBoard.getSudokuBoard().get(3).getSudokuRow().get(2).setValue(7);
        sudokuBoard.getSudokuBoard().get(4).getSudokuRow().get(2).setValue(9);
        sudokuBoard.getSudokuBoard().get(5).getSudokuRow().get(2).setValue(6);
        sudokuBoard.getSudokuBoard().get(2).getSudokuRow().get(3).setValue(9);
        sudokuBoard.getSudokuBoard().get(2).getSudokuRow().get(4).setValue(5);
        sudokuBoard.getSudokuBoard().get(3).getSudokuRow().get(0).setValue(1);
        sudokuBoard.getSudokuBoard().get(3).getSudokuRow().get(4).setValue(4);
        sudokuBoard.getSudokuBoard().get(3).getSudokuRow().get(6).setValue(6);
        sudokuBoard.getSudokuBoard().get(4).getSudokuRow().get(6).setValue(7);
        sudokuBoard.getSudokuBoard().get(5).getSudokuRow().get(1).setValue(2);
        sudokuBoard.getSudokuBoard().get(5).getSudokuRow().get(3).setValue(5);
        sudokuBoard.getSudokuBoard().get(5).getSudokuRow().get(6).setValue(9);
        sudokuBoard.getSudokuBoard().get(6).getSudokuRow().get(0).setValue(3);
        sudokuBoard.getSudokuBoard().get(6).getSudokuRow().get(3).setValue(7);
        sudokuBoard.getSudokuBoard().get(7).getSudokuRow().get(0).setValue(4);
        sudokuBoard.getSudokuBoard().get(7).getSudokuRow().get(5).setValue(5);
        sudokuBoard.getSudokuBoard().get(7).getSudokuRow().get(6).setValue(3);
        sudokuBoard.getSudokuBoard().get(7).getSudokuRow().get(7).setValue(9);
        sudokuBoard.getSudokuBoard().get(8).getSudokuRow().get(0).setValue(9);
        sudokuBoard.getSudokuBoard().get(8).getSudokuRow().get(3).setValue(2);
        sudokuBoard.getSudokuBoard().get(8).getSudokuRow().get(6).setValue(1);
        sudokuBoard.getSudokuBoard().get(2).getSudokuRow().get(7).setValue(4);
        sudokuBoard.getSudokuBoard().get(7).getSudokuRow().get(2).setValue(2);
        sudokuBoard.getSudokuBoard().get(7).getSudokuRow().get(3).setValue(1);
        sudokuBoard.getSudokuBoard().get(7).getSudokuRow().get(4).setValue(8);
    }

    @Test
    void sudokuResolverUpdatingPossibleValuesTest() {
        //Given
        System.out.println(sudokuBoard);
        SudokuElement sudokuElement = sudokuBoard.getSudokuBoard().get(0).getSudokuRow().get(3);

        //When
        System.out.println(sudokuElement.getPossibleValues());
        solvingMechanics.sudokuCheck(sudokuBoard);


        //Then
        System.out.println(sudokuElement.getPossibleValues());
        System.out.println(sudokuBoard);
    }

    @Test
    void sudokuResolverTest () {
        //Given
        sudokuGame = new SudokuGame();
        System.out.println(sudokuBoard);
        boolean gameFinished = false;
        //When&&Then
        while (!gameFinished) {
            gameFinished = sudokuGame.resolveSudoku(sudokuBoard);
        }
        System.out.println(sudokuBoard);
    }
}
