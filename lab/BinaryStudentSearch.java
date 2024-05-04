
public class BinaryStudentSearch {
    
    private static int binSearchRec(String[] studentname, String key, int left, int right) {
        
        for (int i = 0; i < studentname.length; i++) {
            String fullName = studentname[i];
            String[] parts = fullName.split(" ");
            String firstName = parts[0];
            String lastName = parts[1];
        }
        if (left > right) {
            return -1; 
        }

        int mid = left + (right - left) / 2;

        if (key.equals(studentname[mid])) {
            
            if (mid == 0 || !key.equals(studentname[mid - 1])) {
                return mid;
            } else {
               
                return binSearchRec(studentname, key, left, mid - 1);
            }
        } else if (studentname[mid].compareTo(key) < 0) {
            return binSearchRec(studentname, key, mid + 1, right);
        } else {
            return binSearchRec(studentname, key, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"Adi Baj", "uda kul", "Day Hal", "abc Tho", "abd Dev", "Pet Par"};
        String targetkey = "Pet ";
        int n = arr.length;
        int result = binSearchRec(arr,targetkey,0,n-1);
        
        System.out.println(result);
        // System.out.println(arr[result]);
        for (int i = 0; i < arr.length; i++) {
            String fullName = arr[i];
            String[] parts = fullName.split(" ");
            String firstName = parts[0];
            String lastName = parts[1];
        }
        
    }
}