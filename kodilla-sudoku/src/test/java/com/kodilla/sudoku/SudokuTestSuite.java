package com.kodilla.sudoku;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuTestSuite {

    static SolvingMechanics solvingMechanics;
    static SudokuBoard sudokuBoard;
    static SudokuGame sudokuGame = new SudokuGame();

    @BeforeAll
    static void createABoard() {
        solvingMechanics = new SolvingMechanics();
        sudokuBoard = new SudokuBoard();
        sudokuBoard.getSudokuBoard().get(0).getSudokuRow().get(7).setValue(7);
        sudokuBoard.getSudokuBoard().get(6).getSudokuRow().get(6).setValue(4);
//        sudokuBoard.getSudokuBoard().get(0).getSudokuRow().get(8).setValue(3);
//        sudokuBoard.getSudokuBoard().get(1).getSudokuRow().get(1).setValue(8);
//        sudokuBoard.getSudokuBoard().get(1).getSudokuRow().get(3).setValue(6);
//        sudokuBoard.getSudokuBoard().get(1).getSudokuRow().get(6).setValue(5);
//        sudokuBoard.getSudokuBoard().get(2).getSudokuRow().get(1).setValue(1);
//        sudokuBoard.getSudokuBoard().get(2).getSudokuRow().get(5).setValue(7);
//        sudokuBoard.getSudokuBoard().get(2).getSudokuRow().get(6).setValue(8);
//        sudokuBoard.getSudokuBoard().get(2).getSudokuRow().get(0).setValue(2);
//        sudokuBoard.getSudokuBoard().get(2).getSudokuRow().get(2).setValue(3);
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
        try {
            solvingMechanics.singleLoopSudokuSolver(sudokuBoard);
        }catch (NoPossibleValuesException e) {
            SudokuConsole.exceptionMessage(e.getMessage());
        }


        //Then
        System.out.println(sudokuElement.getPossibleValues());
        System.out.println(sudokuBoard);
    }

    @Test
    void sudokuResolverTest() {
        //Given
        System.out.println(sudokuBoard);
        boolean gameFinished = false;
        //When&&Then
        while (!gameFinished) {
            gameFinished = sudokuGame.resolveSudoku(sudokuBoard);
        }
        System.out.println(sudokuBoard);
    }

    @Test
    void backTrackTest() {
        //Given
        //When
        BackTrack backTrack = new BackTrack(0, 0, 1);
        backTrack.saveBoardCopy(sudokuBoard);
        SudokuBoard sudokuBoardCopy = backTrack.getSudokuBoardCopy();
        int i = backTrack.getiOfGuessingElement();
        int j = backTrack.getjOfGuessingElement();
        int value = backTrack.getGuessingValueOfElement();
        //Then
        assertEquals(0, i);
        assertEquals(0, j);
        assertEquals(1, value);
        assertEquals(sudokuBoard.getSudokuBoard().get(5).getSudokuRow().get(5),
                sudokuBoardCopy.getSudokuBoard().get(5).getSudokuRow().get(5));
        System.out.println(sudokuBoard);
        System.out.println(sudokuBoardCopy);
    }


    @Test
    void areBoardsTheSameTest() {
        //Given
        BackTrack backTrack = new BackTrack(0,0,1);
        backTrack.saveBoardCopy(sudokuBoard);
        SudokuBoard sudokuBoard2;
        sudokuBoard2 = backTrack.getSudokuBoardCopy();
        try {
            solvingMechanics.singleLoopSudokuSolver(sudokuBoard);
        }catch (NoPossibleValuesException e) {
            SudokuConsole.exceptionMessage(e.getMessage());
        }
        //When
        boolean areTheSame1 = sudokuGame.areBoardsTheSame(sudokuBoard, sudokuBoard);
        boolean areTheSame2 = sudokuGame.areBoardsTheSame(sudokuBoard, sudokuBoard2);
        //Then
        System.out.println(sudokuBoard);
        System.out.println(sudokuBoard2);
        assertTrue(areTheSame1);
        assertFalse(areTheSame2);


    }

    @Test
    void areElementsTheSameTest() {
        //Given
        BackTrack backTrack = new BackTrack(0,0,0);
        backTrack.saveBoardCopy(sudokuBoard);
        SudokuBoard sudokuBoardCopy = backTrack.getSudokuBoardCopy();
        //When
        sudokuBoardCopy.getSudokuBoard().get(0).getSudokuRow().get(0).getPossibleValues().remove(0);
        SudokuElement sudokuElement1 = sudokuBoard.getSudokuBoard().get(0).getSudokuRow().get(0);
        SudokuElement sudokuElement2 = sudokuBoardCopy.getSudokuBoard().get(0).getSudokuRow().get(0);
        //Then
        assertNotEquals(sudokuElement1, sudokuElement2);
    }

}
