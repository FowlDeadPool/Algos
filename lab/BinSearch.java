public class BinSearch {
    public static void main(String[] args) {
        String[] arr = {"Adi Baj", "uda kul", "Day Hal", "abc Tho", "abd Dev", "Pet Par"};
        String targetkey = "Baj";
        int n = arr.length;
        int result = binSearchRec(arr, targetkey, 0, n - 1);
        System.out.println(result);
        System.out.println(arr[result]);
    }

    public static int binSearchRec(String[] arr, String targetkey, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        String midValue = arr[mid];

        if (midValue.contains(targetkey)) {
            if (mid == 0 || !arr[mid - 1].contains(targetkey)) {
                return mid;
            } else {
                return binSearchRec(arr, targetkey, low, mid - 1);
            }
        } else if (targetkey.compareTo(midValue) < 0) {
            return binSearchRec(arr, targetkey, low, mid - 1);
        } else {
            return binSearchRec(arr, targetkey, mid + 1, high);
        }
    }
}

   
