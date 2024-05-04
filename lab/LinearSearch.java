public class LinearSearch {
    static int LinSearch(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

public static void main(String[] args) {
    String arr[] = {"aditya", "ball", "cat", "dayita", "enormous", "file", "ghibli", "halo"};
    int res = LinSearch(arr, "halo");
    System.out.println(res);
}
}
