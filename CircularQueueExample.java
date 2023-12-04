// CircularQueue class representing a circular queue
class CircularQueue {
    private int front, rear, size;
    private int[] array;

    // Constructor to initialize the circular queue with a given capacity
    public CircularQueue(int capacity) {
        size = capacity + 1; // One extra space for the circular property
        array = new int[size];
        front = rear = 0;
    }

    // Method to check if the circular queue is empty
    public boolean isEmpty() {
        return front == rear;
    }

    // Method to check if the circular queue is full
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    // Method to get the current size of the circular queue
    public int size() {
        return (rear - front + size) % size;
    }

    // Method to enqueue (insert) an item into the circular queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        array[rear] = item;
        rear = (rear + 1) % size;
    }

    // Method to dequeue (remove) an item from the circular queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Assuming -1 represents an error or an empty queue
        }
        int item = array[front];
        front = (front + 1) % size;
        return item;
    }

    // Method to display the elements of the circular queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Circular Queue: ");
        int i = front;
        do {
            System.out.print(array[i] + " ");
            i = (i + 1) % size;
        } while (i != rear);
        System.out.println();
    }
}

// CircularQueueExample class for testing the circular queue
public class CircularQueueExample {
    public static void main(String[] args) {
        // Create a circular queue with a capacity of 5
        CircularQueue circularQueue = new CircularQueue(5);

        // Enqueue some items
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.display();

        // Dequeue an item and display the updated circular queue
        int dequeuedItem = circularQueue.dequeue();
        System.out.println("Dequeued item: " + dequeuedItem);

        // Enqueue more items and display the final circular queue
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);
        circularQueue.display();
    }
}

