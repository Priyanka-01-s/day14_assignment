import java.util.Arrays;

public class Q6_anagramDetection {

    public static boolean areAnagrams(String str1, String str2) {
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {

        String input1 = "heart";
        String input2 = "earth";

        if (areAnagrams(input1, input2)) {
            System.out.println(input1 + " and " + input2 + " are Anagrams.");
        } else {
            System.out.println(input1 + " and " + input2 + " are not Anagrams.");
        }
    }
}
