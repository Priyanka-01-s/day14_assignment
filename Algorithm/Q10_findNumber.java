import java.util.Scanner;

public class Q10_findNumber {
     public static int findNumber(int low, int high) {
        if (low == high) {
            return low;
        }

        int mid = (low + high) / 2;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Is your number between " + low + " and " + mid + "? (true/false): ");
        boolean isBetween = scanner.nextBoolean();

        if (isBetween) {
            return findNumber(low, mid);
        } else {
            return findNumber(mid + 1, high);
        }
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the value of N (2^n): ");
        int n = scanner.nextInt();
        int N = (int) Math.pow(2, n);

        System.out.println("Guess of a number between 0 and " + (N - 1));

        int guessedNumber = findNumber(0, N - 1);
        System.out.println("Your number is: " + guessedNumber);
        scanner.close();

    }
}
    
