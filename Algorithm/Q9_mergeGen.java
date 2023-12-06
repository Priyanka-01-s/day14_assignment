import java.lang.reflect.Array;
import java.util.Arrays;

public class Q9_mergeGen {
    public static <T extends Comparable<T>> void mergeSort(T[] arr){
        int n = arr.length;

        if(n>1){
            int mid = n/2;

            T[] left = Arrays.copyOfRange(arr, 0, mid);
            T[] right = Arrays.copyOfRange(arr, mid, n);

            mergeSort(left);
            mergeSort(right);

            merge(arr,left,right);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] arr, T[] leftArr, T[] rightArr){

        int left = leftArr.length;
        int right = rightArr.length;

        int i=0,j=0,k=0;

        while(i<left && j<right){
            if(leftArr[i].compareTo(rightArr[j])<=0){
                arr[k++] = leftArr[i++];

            }else{
                arr[k++]=rightArr[j++];
            }
        }

        while(i<left){
            arr[k++]=leftArr[i++];
        }

        while(j<right){
            arr[k++]=rightArr[j++];
        }
    }

    public static <T> void printArray(T[] array){
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        Integer[] intArray = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original Integer Array:");
        printArray(intArray);
        mergeSort(intArray);
        System.out.println("Sorted Integer Array:");
        printArray(intArray);

        String[] stringArray = {"banana", "apple", "orange", "grape", "kiwi"};
        System.out.println("Original String Array:");
        printArray(stringArray);
        mergeSort(stringArray);
        System.out.println("Sorted String Array:");
        printArray(stringArray);
    }
}
