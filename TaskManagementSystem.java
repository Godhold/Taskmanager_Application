import java.util.Scanner;

public class TaskManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack highPriorityStack = new Stack(10);
        Queue normalTaskQueue = new Queue(10);

        int choice;
        do {
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Process Tasks");
            System.out.println("3. View Stack");
            System.out.println("4. View Queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTask(highPriorityStack, normalTaskQueue, scanner);
                    break;
                case 2:
                    processTasks(highPriorityStack, normalTaskQueue);
                    break;
                case 3:
                    displayStack(highPriorityStack);
                    break;
                case 4:
                    displayQueue(normalTaskQueue);
                    break;
                case 5:
                    System.out.println("Exiting Task Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Method to add tasks to the respective stack or queue
    public static void addTask(Stack highPriorityStack, Queue normalTaskQueue, Scanner scanner) {
        System.out.println("Enter Task Details:");
        System.out.print("Task ID: ");
        int taskId = scanner.nextInt();

        System.out.print("Description: ");
        scanner.nextLine(); // Consume newline
        String description = scanner.nextLine();

        System.out.print("Status (pending/completed): ");
        String status = scanner.next();

        System.out.print("Priority (0-10): ");
        int priority = scanner.nextInt();

        Task task = new Task(taskId, description, status, priority);
        
        // Adding task to the appropriate stack or queue based on priority
        if (task.getPriority() >= 0 && task.getPriority() <= 5) {
            normalTaskQueue.enqueue(task);
            System.out.println("Task has been added to the Queue");
        } else if (task.getPriority() > 5 && task.getPriority() <= 10) {
            highPriorityStack.push(task);
            System.out.println("Task has been added to the Stack");
        } else {
            System.out.println("Invalid priority input. Task not added.");
        }
    }

    // Method to process tasks, update their status, and re-add them to their respective stack or queue
    public static void processTasks(Stack highPriorityStack, Queue normalTaskQueue) {
        if (!highPriorityStack.isEmpty()) {
            Task task = highPriorityStack.pop();
            System.out.println("Processing High Priority Task: " + task.getDescription());
            task.setStatus("completed");
            highPriorityStack.push(task); // Re-push the completed task back into the stack
        } else if (!normalTaskQueue.isEmpty()) {
            Task task = normalTaskQueue.dequeue();
            System.out.println("Processing Normal Priority Task: " + task.getDescription());
            task.setStatus("completed");
            normalTaskQueue.enqueue(task); // Re-enqueue the completed task back into the queue
        } else {
            System.out.println("No tasks to process.");
        }
    }

    // Method to display the contents of the high priority stack
    public static void displayStack(Stack highPriorityStack) {
        System.out.println("High Priority Task Stack:");
        highPriorityStack.displayStack();
    }

    // Method to display the contents of the normal priority queue
    public static void displayQueue(Queue normalTaskQueue) {
        System.out.println("Normal Priority Task Queue:");
        normalTaskQueue.displayQueue();
    }
}
