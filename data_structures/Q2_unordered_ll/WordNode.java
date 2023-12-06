package data_structures.Q2_unordered_ll;

class WordNode<T> {
    T data;
    WordNode<T> next;

    public WordNode(T data) {
        this.data = data;
        this.next = null;
    }
}