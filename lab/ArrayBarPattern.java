public class ArrayBarPattern {
    static void print(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("#" + "");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 9, 3, 4, 1, 6, 7, 2, 4};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            print(arr[i]);
            count += arr[i];
        }
        System.out.println(count);

     }
}