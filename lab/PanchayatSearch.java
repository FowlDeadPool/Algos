
public class PanchayatSearch {
    static int LinSearch(String[] name, String targetname) {
        for (int i = 0; i < name.length; i++) {
            String fullName = name[i];
            String[] parts = fullName.split(" ");
            String firstName = parts[0];
            String lastName = parts[1];

            if (firstName.contains(targetname) || lastName.contains(targetname)) {
                System.out.println(firstName+" "+lastName);
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] arr = {"Adi Baj", "Uda Hal", "Day Hal", "abc Tho", "abd Dev", "Pet Par"};
            String targetkey = "Dev";
        int result = LinSearch(arr, targetkey);
        System.out.println(result);
    }
}
   
