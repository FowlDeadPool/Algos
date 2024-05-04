public class MatrixChainMultiplication {


    static int[][] kval;
    static int matchain(int d[], int i, int j) {
        
        if (i == j){
        return 0;
           }      
        
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int count = matchain(d, i, k ) + matchain(d, k + 1, j) + d[i - 1] * d[k] * d[j];
            if (count < min) {
                min = count;
                kval[i][j] = k;  
              }
        }
       
        return min;
    }
    
    
    static void Order(int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            Order(i, kval[i][j]);
            Order(kval[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {

        int[] order = { 4, 5, 6, 7, 8, 9 };
        int n = order.length;
        kval= new int[n+1][n+1];
        int res = matchain(order, 1, n - 1);
        System.out.println(res);
        Order(1,n-1);
        
    }
}
