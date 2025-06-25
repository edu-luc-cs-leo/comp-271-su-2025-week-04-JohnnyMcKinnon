public class DoubleLinkedList implements Comparable<DoubleLinkedList> {

    private static final String DEFAULT_NAME = "Whatever";

    private String name;
    private Node head;
    private Node tail;
    private int size; //keeps track of how many nodes are added/have been added

    /** Basic constructor */
    public DoubleLinkedList(String name) {
        this.name = name;
        this.head = null;
        this.tail = null;
        this.size = 0;
    } // Basic constructor

    public int size() {
    return this.size;
    } //Method size

    /** Default constructor passes default name to basic constructor */
    public DoubleLinkedList() {
        this(DEFAULT_NAME);
    } // default constructor

    // Always* write a toString method for your objects.
    // --------
    // * well, almost always ...
    public String toString() {
        return this.name;
    } // method toString

    /** Add a new node to the linked list */
    public void add(Node node) {
    if (this.head == null) {
        this.head = node;
    } 
    else {
        this.tail.setNext(node);
        node.setPrevious(this.tail);
    }
    this.tail = node;
    this.size++; //where we actually increase size based on the # of nodes
    } //Method add
    
    // overload method add to add a node by value
    public void add(String value) {
    Node newNode = new Node(value);
    add(newNode);
    } // method add

    // implement the comparable interface
    public int compareTo(DoubleLinkedList other) {
    return this.size -  other.size; //comparison based on number of nodes(without transversal)
     } // method compareTo

    //iterates through the doubly array list to find a matching value
 public int indexOf(String value) {
        Node current = this.head;
        int index = 0;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    } //Method indexOf

    public boolean contains(String value) {
        return indexOf(value) != -1;
    } //Boolean contains
} // class DoubleLinkedList