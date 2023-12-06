package data_structures.Q2_unordered_ll;

class WordLinkedList<T> {
    WordNode<T> head;

    public WordLinkedList() {
        this.head = null;
    }

    public void insert(T word) {
        WordNode<T> newNode = new WordNode<>(word);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public boolean search(T word) {
        WordNode<T> current = head;
        while (current != null) {
            if (current.data.equals(word)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(T word) {
        if (head == null) {
            return;
        }

        if (head.data.equals(word)) {
            head = head.next;
            return;
        }

        WordNode<T> current = head;
        WordNode<T> prev = null;

        while (current != null && !current.data.equals(word)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return;
        }

        prev.next = current.next;
    }

    public void display() {
        WordNode<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}