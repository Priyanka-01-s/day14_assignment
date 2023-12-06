package data_structures;

import java.util.Arrays;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
}

class Stack {
    LinkedList list;

    public Stack() {
        this.list = new LinkedList();
    }

    public void push(int data) {
        list.insert(data);
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        int data = list.head.data;
        list.head = list.head.next;
        return data;
    }

    public boolean isEmpty() {
        return list.head == null;
    }
}

public class Q10_AnagramStack {
    public static void main(String[] args) {
        int rangeStart = 0;
        int rangeEnd = 1000;

        Stack anagramStack = findAndPushAnagrams(rangeStart, rangeEnd);

        System.out.println("Prime Numbers with Anagrams in Reverse Order:");
        printAnagramsInReverse(anagramStack);
    }

    private static Stack findAndPushAnagrams(int start, int end) {
        Stack anagramStack = new Stack();

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                for (int j = i + 1; j <= end; j++) {
                    if (isPrime(j) && areAnagrams(i, j)) {
                        anagramStack.push(i);
                        anagramStack.push(j);
                    }
                }
            }
        }

        return anagramStack;
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

    private static boolean areAnagrams(int num1, int num2) {
        char[] arr1 = String.valueOf(num1).toCharArray();
        char[] arr2 = String.valueOf(num2).toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    private static void printAnagramsInReverse(Stack stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
