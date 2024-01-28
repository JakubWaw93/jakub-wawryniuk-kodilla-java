package sudoku;

import java.util.Scanner;


public class SudokuConsole {

    private static final Scanner input = new Scanner(System.in);

    public static int howManyNumbers() {
        System.out.println("How many numbers  do You want to put in the Board?");
        return input.nextInt();
    }


    public static String chooseAnElementAndNumber() {
        System.out.println("Choose a row (1-9), an element (1-9), a number to put in (1-9): ");
        return input.nextLine();
    }

    public static void showResolvedSudokuBoard(SudokuBoard sudokuBoard) {
        System.out.println("Resolved Sudoku Board: ");
        System.out.println(sudokuBoard);
    }



}
