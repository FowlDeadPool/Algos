public class CircularMatrix {

    static void print(int arr[][]){

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }    
    }

    static void SpiralMatrix(int arr[][]){
        int row=5; //rows
        int col=5; //cols
        int top,bottom,left,right;
        top=0;                                                        
        bottom=row-1;
        left=0;
        right=col-1;

while (top<=bottom && left<=right) {
    

        //left-right
        for (int i = left; i <= right ; i++) {
            System.out.print(arr[top][i]);  
        }
        top++;

        // top -bottom
        for (int i = top; i <= bottom; i++) {
            System.out.print(arr[i][right]);            
        }
        right--;
        // right - left
        if (top<=bottom) {
            
        
        for (int i = right; i <= left; i++) {
            System.out.print(arr[bottom][i]);
        }
        bottom--;
    }
    //bottom - top
    if (left<=right) {
        
    
        for (int i = bottom; i <= top; i++) {
            System.out.print(arr[i][left]);
        }
        left++;
    } 
    }
    }

    public static void main(String[] args) {

        int n=5;
        int arr[][] = new int[n][n]; 
        int p = 1; 
        
        }

    }











































        // for (int i = 0; i < 5; i++) {
        //     for (int j = 0; j < 5; j++) {
        //         arr[i][j] = p++;
        //         System.out.print(arr[i][j] + "    ");
        //     }
        //     System.out.println();
        // }
        // print(arr);
        
    

