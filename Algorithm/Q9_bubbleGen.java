import java.util.Arrays;
public class Q9_bubbleGen {
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static <T> void printArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        Integer[] intArray = {64, 25, 12, 22, 11};
        System.out.println("Original Integer Array:");
        printArray(intArray);
        bubbleSort(intArray);
        System.out.println("Sorted Integer Array:");
        printArray(intArray);

        String[] stringArray = {"banana", "apple", "orange", "grape", "kiwi"};
        System.out.println("Original String Array:");
        printArray(stringArray);
        bubbleSort(stringArray);
        System.out.println("Sorted String Array:");
        printArray(stringArray);
    }
}
