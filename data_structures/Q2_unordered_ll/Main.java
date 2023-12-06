package data_structures.Q2_unordered_ll;

import java.util.Scanner;

public class Main {

    private static WordLinkedList<String> processInput(String input) {
        WordLinkedList<String> wordList = new WordLinkedList<>();
        String[] words = input.split("\\s+");
        for (String word : words) {
            wordList.insert(word);
        }
        return wordList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the initial word list
        System.out.println("Enter a string of words separated by spaces:");
        String initialInput = scanner.nextLine();
        WordLinkedList<String> wordList = processInput(initialInput);

        // Display the initial word list
        System.out.println("Initial Word List:");
        wordList.display();

        // Take user input to search/add/remove words
        while (true) {
            System.out.println("\nEnter a word to search (type 'exit' to stop):");
            String userInput = scanner.nextLine().trim();

            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            if (wordList.search(userInput)) {
                System.out.println("Word found! Removing " + userInput + " from the list.");
                wordList.remove(userInput);
            } else {
                System.out.println("Word not found! Adding " + userInput + " to the list.");
                wordList.insert(userInput);
            }

            // Display the updated word list
            System.out.println("Updated Word List:");
            wordList.display();
        }

        // Display the final word list
        System.out.println("Final Word List:");
        wordList.display();
    }
}
