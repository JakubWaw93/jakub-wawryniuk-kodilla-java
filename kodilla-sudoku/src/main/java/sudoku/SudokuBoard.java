package sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    private static List<SudokuRow> sudokuBoard = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            sudokuBoard.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getSudokuBoard() {
        return sudokuBoard;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("    ||");
        for (int j = 1; j <= sudokuBoard.size(); j++ ) {
            sb.append(" (").append(j).append(") |");
        }
        sb.append("\n");
        for (int k = 0; k < sudokuBoard.size(); k++) {
            sb.append("(").append(k + 1).append(")").append(" ||");
            for (int l = 0; l < sudokuBoard.size(); l++) {
                if (l == 2 || l == 5 || l == 8) {
                    sb.append("  ").append(sudokuBoard.get(k).getSudokuRow().get(l)).append("  ||");
                } else {
                    sb.append("  ").append(sudokuBoard.get(k).getSudokuRow().get(l)).append("  |");
                }
            }
            sb.append("\n");
            if (k ==2 || k == 5) {
                sb.append("----------------------------------------------------------------\n");
            }

        }
        return sb.toString();
    }
}
