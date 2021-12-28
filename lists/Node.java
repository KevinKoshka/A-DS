package lists;

public class Node<E> {
    private E element;
    private Node<E> next;
    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }
    public E getElement() {return this.element;}
    public Node<E> getNode() {return this.next;}
    public void setNode(Node<E> next) {this.next = next;}
    public String toString() {return this.element.toString();}
}
