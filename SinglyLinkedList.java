// Node class representing a node in the singly linked list
class Node {
    int data;
    Node next;

    // Constructor to initialize the node with data
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// SinglyLinkedList class representing a singly linked list
public class SinglyLinkedList {
    private Node head; // Head of the linked list

    // Constructor to initialize an empty linked list
    public SinglyLinkedList() {
        this.head = null;
    }

    // Method to insert a new node with given data at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);

        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
        } else {
            // Traverse to the end and add the new node
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to delete a node with a given value from the list
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        // If the node to be deleted is the head
        if (head.data == data) {
            head = head.next;
            return;
        }

        // Traverse the list to find the node to be deleted
        Node current = head;
        Node previous = null;
        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        // If the node is not found
        if (current == null) {
            System.out.println("Node with value " + data + " not found.");
            return;
        }

        // Skip the current node to remove it from the list
        previous.next = current.next;
    }

    // Method to display the elements of the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method for testing the linked list
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        // Inserting elements into the linked list
        sll.insert(10);
        sll.insert(20);
        sll.insert(30);
        sll.insert(40);

        System.out.println("Initial List:");
        sll.display();

        // Deleting a node from the linked list
        sll.delete(20);

        System.out.println("List after deleting node with value 20:");
        sll.display();
    }
}
