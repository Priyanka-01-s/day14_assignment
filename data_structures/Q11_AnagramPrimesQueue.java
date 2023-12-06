package data_structures;

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = next;
    }
}

class Queue{
    Node front, rear;

    public Queue(){
        this.front = this.rear = null;
    }
    public void enqueue(int data){
        Node newNode = new Node(data);

        if(this.rear == null){
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    public int dequeue(){
        if(this.front == null){
            return Integer.MIN_VALUE;
        }
        int data = this.front.data;
        this.front = this.front.next;

        if(this.front == null){
            this.rear = null;
        }
        return data;

    }
    public boolean isEmpty(){
        return this.front == null;
    }
}

public class Q11_AnagramPrimesQueue {
    public static void main(String[] args) {
        Queue anagramPrimesQueue = findAndEnqueueAnagramPrimes(0, 1000);

        System.out.println("Anagram Prime Numbers in the Range 0-1000 (in reverse order):");
        printQueue(anagramPrimesQueue);
    }

    private static Queue findAndEnqueueAnagramPrimes(int start, int end) {
        Queue anagramPrimesQueue = new Queue();

        for (int i = start; i <= end; i++) {
            if (isPrime(i) && isAnagramPrime(i)) {
                anagramPrimesQueue.enqueue(i);
            }
        }

        return anagramPrimesQueue;
    }

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

    private static boolean isAnagramPrime(int num) {
        return true;
    }

    private static void printQueue(Queue queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    
    }
    
}
