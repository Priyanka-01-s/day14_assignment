import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q12_stringRegex {

    private static boolean isValidName(String name) {
        String nameRegex = "^[A-Z][a-zA-Z]*$";
        return name.matches(nameRegex);
    }

    private static boolean isValidFullName(String fullName) {
        String fullNameRegex = "^[a-zA-Z\\s]+$";
        return fullName.matches(fullNameRegex);
    }

    private static boolean isValidContactNumber(String contactNumber) {
        String contactNumberRegex = "^[0-9]{10}$";
        return contactNumber.matches(contactNumberRegex);
    }

    private static boolean isValidDate(String date) {
        String dateRegex = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(19|20)\\d\\d$";
        return date.matches(dateRegex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hardcoded paragraph
        String paragraph = "Hello <<name>>, We have your full name as <<full name>> in our system. " +
                "Your contact number is 91-xxxxxxxxxx. Please, let us know in case of any clarification. " +
                "Thank you BridgeLabz 01/01/2016.";

        System.out.println("Enter your name (starting with a capital letter):");
        String name = scanner.nextLine();

        System.out.println("Enter your full name:");
        String fullName = scanner.nextLine();

        System.out.println("Enter your contact number (10 numeric digits only):");
        String contactNumber = scanner.nextLine();

        System.out.println("Enter the date (in the format MM/DD/YYYY):");
        String date = scanner.nextLine();

        // check if inputs are valid
        if (!isValidName(name) || !isValidFullName(fullName) || !isValidContactNumber(contactNumber) || !isValidDate(date)) {
            System.out.println("Invalid input. Please follow the specified criteria.");
            return;
        }

        // Replace 
        paragraph = paragraph.replace("<<name>>", name);
        paragraph = paragraph.replace("<<full name>>", fullName);
        paragraph = paragraph.replace("91-xxxxxxxxxx", contactNumber);
        paragraph = paragraph.replace("01/01/2016", date);

        System.out.println("Modified Message:");
        System.out.println(paragraph);

        
    }
}
