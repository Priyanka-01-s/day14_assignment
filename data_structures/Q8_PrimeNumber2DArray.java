package data_structures;

import java.util.Arrays;

public class Q8_PrimeNumber2DArray {

    public static void main(String[] args) {
        int[][] primeRanges = findPrimesInRange(0, 1000, 100);

        for (int i = 0; i < primeRanges.length; i++) {
            System.out.println("Prime numbers in the range " + (i * 100) + " to " + ((i + 1) * 100 - 1) + ":");
            for (int j = 0; j < primeRanges[i].length && primeRanges[i][j] != 0; j++) {
                System.out.print(primeRanges[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] findPrimesInRange(int start, int end, int rangeSize) {
        int totalRanges = (end - start) / rangeSize + 1;
        int[][] primeRanges = new int[totalRanges][];
        
        int currentRange = 0;
        int currentPrimeIndex = 0;

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                if (currentPrimeIndex == 0) {
                    primeRanges[currentRange] = new int[rangeSize];
                }

                primeRanges[currentRange][currentPrimeIndex] = i;
                currentPrimeIndex++;

                if (currentPrimeIndex == rangeSize) {
                    currentRange++;
                    currentPrimeIndex = 0;
                }
            }
        }

        return primeRanges;
    }

    // Function to check if a number is prime
    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
