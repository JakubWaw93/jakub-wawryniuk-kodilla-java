package sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class SudokuConsole {

    private static final Scanner input = new Scanner(System.in);

    public static int info() {
        System.out.println("How many numbers  do You want to put in the Board?");
        return input.nextInt();
    }


    public static String chooseAnElementAndNumber() {
        System.out.println("Choose a row (1-9), an element (1-9), a number to put in (1-9): ");
        return input.nextLine();
    }


}
