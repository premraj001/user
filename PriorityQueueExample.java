// Patient class representing a patient with a name and priority
class Patient {
    String name;
    int priority;

    // Constructor to initialize a patient with a name and priority
    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}


// Node class representing a node in the priority queue
class Node {
    Patient patient;
    Node next;

    // Constructor to initialize a node with a patient
    public Node(Patient patient) {
        this.patient = patient;
        this.next = null;
    }
}


// PriorityQueue class representing a priority queue of patients
class PriorityQueue {
    private Node front;

    // Constructor to initialize an empty priority queue
    public PriorityQueue() {
        this.front = null;
    }

    // Method to enqueue (insert) a patient into the priority queue based on priority
    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);

        // If the queue is empty or the patient has higher priority than the front
        if (front == null || patient.priority > front.patient.priority) {
            newNode.next = front;
            front = newNode;
        } else {
            // Traverse the queue to find the correct position based on priority
            Node current = front;
            while (current.next != null && patient.priority <= current.next.patient.priority) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Method to dequeue (remove) a patient with the highest priority from the queue
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty. Cannot dequeue.");
            return null;
        }
        Patient dequeuedPatient = front.patient;
        front = front.next;
        return dequeuedPatient;
    }

    // Method to check if the priority queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Method to display the elements of the priority queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty.");
            return;
        }
        Node current = front;
        System.out.println("Priority Queue (Front to Rear):");
        while (current != null) {
            System.out.println("Name: " + current.patient.name + ", Priority: " + current.patient.priority);
            current = current.next;
        }
    }
}

// PriorityQueueExample class for testing the priority queue
public class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a priority queue
        PriorityQueue priorityQueue = new PriorityQueue();

        // Enqueue patients with different priorities
        priorityQueue.enqueue(new Patient("John", 3));
        priorityQueue.enqueue(new Patient("Jane", 1));
        priorityQueue.enqueue(new Patient("Doe", 2));

        // Display the priority queue
        priorityQueue.display();

        // Dequeue and display the highest priority patient
        Patient dequeuedPatient = priorityQueue.dequeue();
        System.out.println("Dequeued patient: " + dequeuedPatient.name);

        // Display the updated priority queue
        priorityQueue.display();
    }
}


// OUTPUT:
// Priority Queue (Front to Rear):
// Name: John, Priority: 3
// Name: Doe, Priority: 2
// Name: Jane, Priority: 1
// Dequeued patient: John
// Priority Queue (Front to Rear):
// Name: Doe, Priority: 2
// Name: Jane, Priority: 1