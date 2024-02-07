package com.kodilla.sudoku;

import java.util.Scanner;


public class SudokuConsole {

    private static final Scanner input = new Scanner(System.in);

    public static int howManyNumbers() {
        System.out.println("How many numbers  do You want to put in the Board?");
        int result =  input.nextInt();
        input.nextLine();
        return result;
    }


    public static String chooseAnElementAndNumber() {
        System.out.println("Choose a row (1-9), an element (1-9), a number to put in (1-9)" +
                "\nor 'x' to end creation of sudoku board: ");
        return input.nextLine();
    }

    public static void showSudokuBoard(SudokuBoard sudokuBoard) {
        System.out.println(sudokuBoard);
    }

    public static void exceptionMessage(String message) {
        System.out.println("Exception message: " + message);
    }

    public static void incorrectSudoku() {
        System.out.println("This sudoku board is empty");
    }



}
