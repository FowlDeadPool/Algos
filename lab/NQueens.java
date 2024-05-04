
import java.util.*;

public class NQueens {
    final static int numQ = 4;
     

     static int[] currentSolution = new int[numQ];
     static ArrayList<int[]> solutions = new ArrayList<>();


    public boolean isSafe(int Row, int Col) {
        if (Row == 0) {
            return true;
        }
        for (int row = 0; row < Row; row++) {
            if (Col == currentSolution[row]) {
                return false;
            }
            if (Math.abs(Row - row) == Math.abs(Col - currentSolution[row])) {
                return false;
            }
        }
        return true;
    }

    public void placeQueen(int row) {
        for (int col = 0; col < numQ; col++) {
            if (!isSafe(row, col)) {
                continue;
            }
            currentSolution[row] = col;
            if (row == numQ - 1) {
                solutions.add(currentSolution.clone());
                System.out.println("Solution number " + solutions.size() + ": " + Arrays.toString(currentSolution));
            } else {
                placeQueen(row + 1);
            }
        }
    }

    public static void main(String[] args) {
        NQueens nq = new NQueens();
        nq.placeQueen(0);
    }
}
