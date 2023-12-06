package data_structures.Q1_ordered_ll;

class OrderedNumberLinkedList<T extends Comparable<T>> {
    Node<T> head;

    public OrderedNumberLinkedList() {
        this.head = null;
    }

    public void insert(T number) {
        Node<T> newNode = new Node<>(number);

        if (head == null || head.data.compareTo(number) >= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null && current.next.data.compareTo(number) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void remove(T number) {
        if (head == null) {
            return;
        }

        if (head.data.compareTo(number) == 0) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        Node<T> prev = null;

        while (current != null && current.data.compareTo(number) != 0) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return;
        }

        prev.next = current.next;
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}