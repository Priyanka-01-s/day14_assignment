package data_structures;

import java.util.LinkedList;

class HashTable {
    private static final int NUM_SLOTS = 10;
    private LinkedList<Integer>[] slots;

    public HashTable() {
        this.slots = new LinkedList[NUM_SLOTS];
        for (int i = 0; i < NUM_SLOTS; i++) {
            slots[i] = new LinkedList<>();
        }
    }

    public void insert(int number) {
        int hash = hashFunction(number);
        slots[hash].add(number);
    }

    public boolean search(int number) {
        int hash = hashFunction(number);
        return slots[hash].contains(number);
    }

    public void display() {
        for (int i = 0; i < NUM_SLOTS; i++) {
            System.out.print("Slot " + i + ": ");
            for (int num : slots[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private int hashFunction(int number) {
       
        return number % NUM_SLOTS;
    }
}

public class Q6_NumberSlot {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.insert(5);
        hashTable.insert(15);
        hashTable.insert(25);
        hashTable.insert(7);
        hashTable.insert(17);

        // Display the contents of the hash table
        System.out.println("Initial Hash Table:");
        hashTable.display();

        // Search for a number in the hash table
        int searchNumber = 15;
        if (hashTable.search(searchNumber)) {
            System.out.println("Number " + searchNumber + " found in the hash table.");
        } else {
            System.out.println("Number " + searchNumber + " not found in the hash table.");
        }
    }
}
