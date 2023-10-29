public class Stack {
    private Task[] stackArray;  // Array to hold the stack elements
    private int top;            // Pointer to the top element in the stack
    private int maxSize;        // Maximum size of the stack

    // Constructor to initialize the stack with a given size
    public Stack(int size) {
        maxSize = size;
        stackArray = new Task[maxSize];  // Creating the array for stack elements
        top = -1;                        // Initializing top pointer
    }

    // Method to add an element to the top of the stack (push operation)
    public void push(Task task) {
        if (!isFull()) {
            // If the stack is empty or the task's priority is higher, add it to the top
            if (isEmpty() || task.getPriority() >= stackArray[top].getPriority()) {
                stackArray[++top] = task;
            } else {
                int tempTop = top;
                // Shift elements to maintain descending order based on priority
                while (tempTop >= 0 && task.getPriority() < stackArray[tempTop].getPriority()) {
                    stackArray[tempTop + 1] = stackArray[tempTop];
                    tempTop--;
                }
                stackArray[tempTop + 1] = task;
                top++;
            }
        } else {
            System.out.println("Stack overflow");
        }
    }

    // Method to remove and return the top element from the stack (pop operation)
    public Task pop() {
        if (!isEmpty()) {
            return stackArray[top--];  // Return the top element and decrement the top pointer
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    // Method to return the top element without removing it
    public Task top() {
        if (!isEmpty()) {
            return stackArray[top];
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);  // Stack is empty if the top pointer is -1
    }
    
    // Method to check if the stack is full
    public boolean isFull() {
        return top == maxSize - 1;  // Stack is full if the top pointer is at the maximum index
    }

    // Method to display the contents of the stack
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack Contents:");
        for (int i = top; i >= 0; i--) {
            Task currentTask = stackArray[i];
            System.out.println("Task ID: " + currentTask.getTaskID() +
                    ", Description: " + currentTask.getDescription() +
                    ", Status: " + currentTask.getStatus() +
                    ", Priority: " + currentTask.getPriority());
        }
    }
}
