package data_structures;

import java.util.LinkedList;
import java.util.Queue;

class People {
    String work;
    int amount;

    People(String w, int a) {
        this.work = w;
        this.amount = a;
    }

    @Override
    public String toString() {
        return "People{" +
                "work='" + work + '\'' +
                ", amount=" + amount +
                '}';
    }
}

class CashCounter {
    static Queue<People> queue = new LinkedList<>();
    int amount = 0;

    public void enqueue(People p) {
        queue.add(p);
        if (p.work.equals("deposit")) {
            amount += p.amount;
        } else if (p.work.equals("withdraw")) {
            //withdrawal amount doesn't exceed the current balance
            if (p.amount <= amount) {
                amount -= p.amount;
            } else {
                System.out.println("Insufficient funds for withdrawal.");
            }
        }
        display();
    }

    public void dequeue() {
        People removedPerson = queue.poll();
        if (removedPerson != null) {
            if (removedPerson.work.equals("deposit")) {
                amount -= removedPerson.amount;
            } else if (removedPerson.work.equals("withdraw")) {
                // withdrawal amount has already been deducted during enqueue
            }
            display();
        } else {
            System.out.println("Queue is empty.");
        }
    }

    private void display() {
        System.out.println("Queue: " + queue);
        System.out.println("The current balance in the bank is= " + amount);
        System.out.println();
    }
}

public class Q4_BankingCashCounter {
    public static void main(String[] args) {
        CashCounter obj = new CashCounter();
        People p1 = new People("deposit", 1000);
        obj.enqueue(p1);
        People p2 = new People("deposit", 2000);
        obj.enqueue(p2);
        People p3 = new People("withdraw", 500);
        obj.enqueue(p3);
        People p4 = new People("deposit", 100);
        obj.enqueue(p4);
        People p5 = new People("withdraw", 550);
        obj.enqueue(p5);
        obj.dequeue();
        obj.dequeue();
    }
}
