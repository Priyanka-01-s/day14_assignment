import java.util.Arrays;

public class Q8_primeAnagram {
    public static boolean isPrime(int num) {
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

    // Function to check if a number is an anagram of another number
    public static boolean areAnagrams(int num1, int num2) {
        char[] charArray1 = Integer.toString(num1).toCharArray();
        char[] charArray2 = Integer.toString(num2).toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    // Function to check if a number is a palindrome
    public static boolean isPalindrome(int num) {
        String str = Integer.toString(num);
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }

    public static void main(String[] args) {
        System.out.println("Prime numbers, which are also Anagrams and Palindromes in the range 0 to 1000:");

        for (int i = 0; i <= 1000; i++) {
            if (isPrime(i)) {
                for (int j = i + 1; j <= 1000; j++) {
                    if (isPrime(j) && areAnagrams(i, j) && isPalindrome(i)) {
                        System.out.println(i + " is a Prime, Anagram, and Palindrome.");
                        break;
                    }
                }
            }
        }
    }
}
