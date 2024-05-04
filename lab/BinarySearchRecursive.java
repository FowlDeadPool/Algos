public class BinarySearchRecursive {
    public static void main(String[] args) {
        int arr[] = {100, 2, 3, 42, 5, 60, 7, 89};
        // int[] test_Array=BubbleSort(arr);
        // for (int i : test_Array) {
        //     System.out.print(i+" ");
        // }
        int n=arr.length;
        BubbleSort(arr);
        int left=0;
        int right=n-1;
        int test=binSearchRec(arr, 42, left, right);
            System.out.println(test);
        
    }

    static int[] BubbleSort(int[] arr){
        int a=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j]<arr[i]) {
                    a=arr[j];
                    arr[j]=arr[i];
                    arr[i]=a;
                }
            }

        }
        return arr;

    }

    private static int binSearchRec(int[] arr, int key, int left, int right) {
         if (left>right) {
            return -1;
         }
         int mid = left + (right-left)/2;
          if (key==arr[mid]) {
                return mid;
            }
            if (arr[mid]<key) {
               return binSearchRec(arr, key, mid+1, right);
            }
            else{
               return binSearchRec(arr, key, left , mid-1);
    }

}
}
