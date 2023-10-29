public class Queue {
    private Task[] queueArray;  // Array to hold the queue elements
    private int front;          // Pointer to the front element in the queue
    private int rear;           // Pointer to the rear element in the queue
    private int size;           // Number of elements in the queue
    private int capacity;       // Maximum capacity of the queue

    // Constructor to initialize the queue with a given capacity
    public Queue(int capacity){
        this.capacity = capacity;
        queueArray = new Task[capacity];  // Creating the array for queue elements
        size = 0;
        front = 0;                      // Initializing front pointer
        rear = capacity - 1;            // Initializing rear pointer
    }

    // Method to add an element to the rear of the queue (enqueue operation)
    public void enqueue(Task task) {
        if (size == capacity) {
            return;  // Queue is full, cannot add more elements
        }

        rear = (rear + 1) % capacity;  // Circularly move the rear pointer
        queueArray[rear] = task;       // Add the element to the rear of the queue
        size++;                        // Increment the size
    }

    // Method to remove and return an element from the front of the queue (dequeue operation)
    public Task dequeue() {
        if (size == 0) {
            return null;  // Queue is empty, cannot remove elements
        }

        Task task = queueArray[front];  // Get the element at the front
        front = (front + 1) % capacity; // Circularly move the front pointer
        size--;                         // Decrement the size
        return task;                    // Return the dequeued element
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;  // Queue is empty if the size is zero
    }

    // Method to display the contents of the queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        int current = front;
        int count = 0;

        System.out.println("Queue Contents:");
        while (count < size) {
            Task currentTask = queueArray[current];
            System.out.println("Task ID: " + currentTask.getTaskID() +
                    ", Description: " + currentTask.getDescription() +
                    ", Status: " + currentTask.getStatus() +
                    ", Priority: " + currentTask.getPriority());
            
            current = (current + 1) % capacity;  // Move to the next element in the circular array
            count++;
        }
    }
}
