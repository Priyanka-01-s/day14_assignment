import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1_permutation {

    public static List<String> iterativePermutations(String input) {
        List<String> result = new ArrayList<>();
        result.add("");

        for (char ch : input.toCharArray()) {
            List<String> newPermutations = new ArrayList<>();
            for (String permutation : result) {
                for (int i = 0; i <= permutation.length(); i++) {
                    newPermutations.add(permutation.substring(0, i) + ch + permutation.substring(i));
                }
            }
            result = newPermutations;
        }

        return result;
    }

    public static List<String> recursivePermutations(String input) {
        List<String> result = new ArrayList<>();
        recursive("", input, result);
        return result;
    }

    private static void recursive(String prefix, String suffix, List<String> result) {
        if (suffix.length() == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                recursive(prefix + suffix.charAt(i),
                        suffix.substring(0, i) + suffix.substring(i + 1), result);
            }
        }
    }

    public static boolean arrayEqual(String[] arr1, String[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        String input = "code";

        // Using iterative method
        List<String> iterativeResult = iterativePermutations(input);
        System.out.println("Iterative Permutations: " + iterativeResult);

        // Using recursive method
        List<String> recursiveResult = recursivePermutations(input);
        System.out.println("Recursive Permutations: " + recursiveResult);

        // Check if the arrays are equal
        System.out.println("Arrays are equal: " +
                arrayEqual(iterativeResult.toArray(new String[0]), recursiveResult.toArray(new String[0])));
    }
}
