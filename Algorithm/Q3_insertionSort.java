public class Q3_insertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // start with second ele ment

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = { 12, 11, 13, 5, 6 };

        System.out.println("Original Array:");
        printArray(array);

        // Sorting using insertion sort
        insertionSort(array);

        System.out.println("Sorted Array after insertion sorting:");
        printArray(array);
    }
}
