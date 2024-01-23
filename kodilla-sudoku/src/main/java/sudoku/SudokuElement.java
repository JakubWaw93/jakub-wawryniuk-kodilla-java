package sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {

    private int value;
    public static final int EMPTY = -1;
    private List<Integer> possibleValues = new ArrayList<>();

    public SudokuElement(int value) {
        this.value = value;
        possibleValues.add(1);
        possibleValues.add(2);
        possibleValues.add(3);
        possibleValues.add(4);
        possibleValues.add(5);
        possibleValues.add(6);
        possibleValues.add(7);
        possibleValues.add(8);
        possibleValues.add(9);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String result;
        if (value == EMPTY) {
            result = " ";
        } else {
            result = String.valueOf(value);
        }
        return result;
    }
}
