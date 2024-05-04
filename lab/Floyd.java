
//not complete
import java.util.Arrays;

public class Floyd {
    final static int INF = 99999;

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 3, INF, 7 },
                { 8, 0, 2, INF },
                { 5, INF, 0, 1 },
                { 2, INF, INF, 0 }
        };

        int[][] mat2 = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                mat2[i][j] = matrix[i][j];
            }
        }

        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (mat2[i][k] + mat2[k][j] < mat2[i][j])
                        mat2[i][j] = mat2[i][k] + mat2[k][j];
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("updated matrix");
        for (int i = 0; i < mat2.length; i++) {
            System.out.println(Arrays.toString(mat2[i]));
        }

    }
}
