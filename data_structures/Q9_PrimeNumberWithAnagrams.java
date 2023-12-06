package data_structures;

import java.util.ArrayList;
import java.util.Arrays;

public class Q9_PrimeNumberWithAnagrams {
    public static void main(String[] args) {
        int rangeStart = 0;
        int rangeEnd = 1000;

        ArrayList<Integer> primes = findPrimesInRange(rangeStart, rangeEnd);
        int[][] anagramArray = categorizeAnagrams(primes);

        // Display the results
        System.out.println("Prime Numbers with Anagrams:");
        displayArray(anagramArray[0]);

        System.out.println("\nPrime Numbers without Anagrams:");
        displayArray(anagramArray[1]);
    }

    private static ArrayList<Integer> findPrimesInRange(int start, int end) {
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        return primes;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int[][] categorizeAnagrams(ArrayList<Integer> primes) {
        int[][] anagramArray = new int[2][primes.size()];
        int anagramIndex = 0;
        int nonAnagramIndex = 0;

        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                if (areAnagrams(primes.get(i), primes.get(j))) {
                    anagramArray[0][anagramIndex++] = primes.get(i);
                    anagramArray[0][anagramIndex++] = primes.get(j);
                }
            }
            if (anagramIndex == 0 || !contains(anagramArray[0], primes.get(i), anagramIndex)) {
                anagramArray[1][nonAnagramIndex++] = primes.get(i);
            }
        }

        return anagramArray;
    }

    private static boolean areAnagrams(int num1, int num2) {
        char[] arr1 = String.valueOf(num1).toCharArray();
        char[] arr2 = String.valueOf(num2).toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    private static void displayArray(int[] array) {
        for (int i = 0; i < array.length && array[i] != 0; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private static boolean contains(int[] array, int key, int length) {
        for (int i = 0; i < length; i++) {
            if (array[i] == key) {
                return true;
            }
        }
        return false;
    }
}
