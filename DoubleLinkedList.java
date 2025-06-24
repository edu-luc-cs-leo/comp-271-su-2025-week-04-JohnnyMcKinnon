public class DoubleLinkedList implements Comparable<DoubleLinkedList> {

    private static final String DEFAULT_NAME = "Whatever";

    private String name;
    private Node head;
    private Node tail;
    private int size;

    /** Basic constructor */
    public DoubleLinkedList(String name) {
        this.name = name;
        this.head = null;
        this.tail = null;
        this.size = 0;
    } // Basic constructor

    /** Default constructor passes default name to basic constructor */
    public DoubleLinkedList() {
        this(DEFAULT_NAME);
    } // default constructor

    // Always* write a toString method for your objects.
    // --------
    // * well, almost always ...
    public String toString() {
        return this.name + " (size=" + size + ")";
    } // method toString

    /** Add a new node to the linked list */
    public void add(Node node) {
        if (node == null) {
            return; // nothing to add
        }
        if (this.head == null) { // first node
            this.head = node;
            this.tail = node;
        } else { // add to tail
            this.tail.setNext(node);
            node.setPrevious(this.tail); // maintains previous pointer
            this.tail = node;
        }
        size++; // update count
    } // method add

    // overload method add to add a node by value
    public void add(String value) {
        add(new Node(value));
    } // method add

    //return current nodes
    public int size() {
        return this.size;
    } // method size

    // implement the comparable interface
    public int compareTo(DoubleLinkedList other) {
        if (other == null) {
            return 1; // a non‑null list is "greater" than null
        }
        else{
        return Integer.compare(this.size, other.size());
    } // method compareTo

    //Return index of the first node with value equal to given string, or −1 if no such node exists.
    public int indexOf(String value) {
        int index = 0;
        for (Node current = head; current != null; current = current.getNext()) {
            if (current.getValue().equals(value)) {
                return index;
            }
            index++;
        }
        return -1;
    } // method indexOf
    //Return true if the list contains a node whose value equals the given string.
    public boolean contains(String value) {
        return indexOf(value) != -1;
    } // method contains
} // class DoubleLinkedList
