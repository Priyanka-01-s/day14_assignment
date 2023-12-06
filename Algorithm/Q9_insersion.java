import java.util.Arrays;
public class Q9_insersion {
    public static <T extends Comparable<T>> void insertion(T[] arr){
        int n = arr.length;

        // start with second ele ment
        for (int i = 1; i < n; ++i) {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static <T> void printArray(T[] arr){
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        Integer[] intArray = {12, 11, 13, 5, 6};
        System.out.println("Original Integer Array:");
        printArray(intArray);
        insertion(intArray);
        System.out.println("Sorted Integer Array:");
        printArray(intArray);

        String[] stringArray = {"banana", "apple", "orange", "grape", "kiwi"};
        System.out.println("Original String Array:");
        printArray(stringArray);
        insertion(stringArray);
        System.out.println("Sorted String Array:");
        printArray(stringArray);
    }
    
}
