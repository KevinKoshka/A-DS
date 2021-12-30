package lists;

public class DoubleLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public void setNext(Node<E> next) {this.next = next;}
        public void setPrev(Node<E> prev) {this.prev = prev;}
        public Node<E> getNext() {return this.next;}
        public Node<E> getPrev() {return this.prev;}
        public E getElement() {return this.element;}
        public String toString() {return this.element.toString();}
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoubleLinkedList() {
        this.header = new Node<E>(null, null, null);
        this.trailer = new Node<E>(null, this.header, null);
        this.header.setNext(this.trailer);
    }
    public int size() {return this.size;}
    public boolean isEmpty() {return this.size == 0;}
    public E first() {
        if (this.isEmpty()) {
            return null;
        }
        return this.header.getNext().getElement();
    }
    public E last() {
        if (this.isEmpty()) {
            return null;
        }
        return this.trailer.getPrev().getElement();
    }
    public void addFirst(E element) {
        Node<E> newNode = new Node<E>(element, this.header, this.header.getNext());
        this.header.getNext().setPrev(newNode);
        this.header.setNext(newNode);
        size++;
    }
    public void addLast(E element) {
        Node<E> newNode = new Node<E>(element, this.trailer.getPrev(), this.trailer);
        this.trailer.getPrev().setNext(newNode);
        this.trailer.setPrev(newNode);
        size++;
    }
    public E removeLast() {
        E element = this.last();
        if (element == null) {
            return null;
        } else {
            this.trailer.setPrev(this.trailer.getPrev().getPrev());
            this.trailer.getPrev().setNext(this.trailer);
            return element;
        }
    }
    public E removeFirst() {
        E element = this.first();
        if (element == null) {
            return null;
        } else {
            this.header.setNext(this.header.getNext().getNext());
            this.header.getNext().setPrev(this.header);
            return element;
        }
    }
    public String toString() {
        if (this.isEmpty()) {
            return "List is empty";
        }
        String theString = new String("Double Linked List:\n");
        Node<E> currentNode = null;
        do {
            if (currentNode == null) {
                currentNode = this.header.getNext();
            } else {
                currentNode = currentNode.getNext();
            }
            theString = theString + currentNode.toString() + "\n";
        } while (currentNode.getNext() != this.trailer);
        return theString;
    }
}
