public class Task{
    private int task_id;         // Unique identifier for the task
    private String description;  // Description of the task
    private String status;       // Status of the task (pending/completed)
    private int priority;        // Priority of the task (0-10)

    // Constructor to initialize a task with provided details
    public Task(int id, String description, String status, int priority) {
        this.task_id = id;          // Set task ID
        this.description = description;  // Set task description
        this.status = status;       // Set task status
        setPriority(priority);      // Set task priority
    }

    // Getters and setters for task attributes

    public int getTaskID() {
        return task_id;  // Retrieve task ID
    }

    public void setTaskId(int id) {
        task_id = id;  // Set task ID
    }

    public String getDescription() {
        return description;  // Retrieve task description
    }

    public void setDescription(String desc) {
        description = desc;  // Set task description
    }

    public String getStatus() {
        return status;  // Retrieve task status
    }

    public void setStatus(String stat) {
        status = stat;  // Set task status
    }

    public int getPriority() {
        return priority;  // Retrieve task priority
    }

    public void setPriority(int priority) {
        // Set task priority within valid range and categorize as low or high priority
        if (priority >= 0 && priority <= 10) {
            if (isLowPriority(priority)) {
                setLowPriority(priority);  // Set low priority
                System.out.println("Normal Priority");
            } else {
                setHighPriority(priority);  // Set high priority
                System.out.println("High Priority");
            }
        }
    }

    // Methods to check priority level
    public boolean isLowPriority(int priority) {
        return priority >= 0 && priority <= 5;  // Check if priority is low
    }

    public boolean isHighPriority(int priority) {
        return priority >= 5 && priority <= 10;  // Check if priority is high
    }

    // Setters for low and high priority
    public void setLowPriority(int priority) {
        this.priority = priority;  // Set low priority
    }

    public void setHighPriority(int priority) {
        this.priority = priority;  // Set high priority
    }
}
