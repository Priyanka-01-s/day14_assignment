package data_structures.Q1_ordered_ll;

import java.util.Scanner;

public class Main {

    private static OrderedNumberLinkedList<Integer> processInput(String input) {
        OrderedNumberLinkedList<Integer> numberList = new OrderedNumberLinkedList<>();
        String[] numbers = input.split("\\s+");
        for (String numberStr : numbers) {
            int number = Integer.parseInt(numberStr);
            numberList.insert(number);
        }
        return numberList;
    }

    private static boolean numberListContains(OrderedNumberLinkedList<Integer> numberList, int number) {
        Node<Integer> current = numberList.head;
        while (current != null) {
            if (current.data == number) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers separated by spaces:");
        String initialInput = scanner.nextLine();
        OrderedNumberLinkedList<Integer> numberList = processInput(initialInput);

        System.out.println("Initial Number List:");
        numberList.display();

        while (true) {
            System.out.println("\nEnter a number to search (type 'exit' to stop):");
            String userInput = scanner.nextLine().trim();

            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            int number = Integer.parseInt(userInput);

            if (numberListContains(numberList, number)) {
                System.out.println("Number found! Removing " + number + " from the list.");
                numberList.remove(number);
            } else {
                System.out.println("Number not found! Adding " + number + " to the list.");
                numberList.insert(number);
            }

            System.out.println("Updated Number List:");
            numberList.display();
        }

        System.out.println("Final Number List:");
        numberList.display();
    }    
}
