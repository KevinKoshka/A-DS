package lists;

public class SingleLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SingleLinkedList() {}

    public boolean isEmpty() {return this.size == 0;}
    public E getFirst() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.head.getElement();
        }
    }
    public E getLast() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.tail.getElement();
        }
    }
    public void insertFirst(E element) {
        Node<E> newNode = new Node<E>(element, null);
        newNode.setNode(this.head);
        this.head = newNode;
        if (this.isEmpty()) {
            this.tail = this.head;
        }
        this.size++;
    }
    public void insertLast(E element) {
        Node<E> newNode = new Node<E>(element, null);
        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.setNode(newNode);
        }
        this.tail = newNode;
        this.size++;
    }
    public E removeFirst() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return null;
        }
        E element = this.head.getElement();
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNode();
        }
        size--;
        return element;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "List is empty";
        }
        String theString = new String("Single Linked List:\n");
        Node<E> currentNode = null;
        do {
            if (currentNode == null) {
                currentNode = this.head;
            } else {
                currentNode = currentNode.getNode();
            }
            theString = theString + currentNode.toString() + "\n";
        } while (currentNode.getNode() != null);
        return theString;
    }
}