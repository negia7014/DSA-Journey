// Node class represents a single node in the linked list
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
// LinkedList class contains the head of the list and insertion methods
public class LinkedList {
    Node head;
// Method to insert a new node at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
`  // Method to insert a new node at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
  // If the list is empty, the new node becomes the head
        if (head == null) {
            head = newNode;
            return;
        }
      // Traverse to the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Link the last node to the new node
        current.next = newNode;
    }

    // Method to insert a new node at a specified position
    public void insertAtPosition(int data, int position) {
        // Handle insertion at the beginning
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;

        // Traverse to the node just before the insertion position
        // The loop runs position - 2 times to stop at the (position - 1)th node
        for (int i = 0; i < position - 2; i++) {
            // Check for out-of-bounds position
            if (current == null) {
                throw new IllegalArgumentException("Position is out of bounds");
            }
            current = current.next;
        }

        // Link the new node into the list
        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insertion at Beginning
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        System.out.print("List after beginning insertions: ");
        list.printList(); // Output: 20 -> 10 -> null

        // Insertion at End
        list.insertAtEnd(30);
        System.out.print("List after end insertion: ");
        list.printList(); // Output: 20 -> 10 -> 30 -> null

        // Insertion at a specific position (e.g., middle)
        list.insertAtPosition(15, 2);
        System.out.print("List after middle insertion at position 2: ");
        list.printList(); // Output: 20 -> 15 -> 10 -> 30 -> null
    }
}
