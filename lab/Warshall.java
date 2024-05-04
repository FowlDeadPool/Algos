import java.util.Arrays;

public class Warshall {

    public static void main(String[] args) {
        
        int[][] matrix = {
            { 0, 1, 0, 0 },
            { 1, 0, 1, 0 },
            { 0, 0, 0, 1 },
            { 0, 0, 0, 0 }
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
                if (mat2[i][j] != 0  || mat2[i][k] != 0 && mat2[k][j] != 0) {
                    mat2[i][j] = 1;
                } else {
                    mat2[i][j] = 0;
                }
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


    // int source = 0; 
    // int destination = 3;
    
    // for (int k = 0; k < matrix.length; k++) {
    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix.length; j++) {
    //             if (mat2[i][k] != 0 && mat2[k][j] != 0) {
    //                 System.out.print((mat2[i][j]));
    //             } else {
                    
    //             }
    //         }
    //     }
    // }



    }
}
    
































