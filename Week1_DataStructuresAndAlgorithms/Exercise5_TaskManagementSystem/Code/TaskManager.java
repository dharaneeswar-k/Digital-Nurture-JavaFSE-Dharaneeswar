package Week1_DataStructuresAndAlgorithms.Exercise5_TaskManagementSystem.Code;

class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}

class TaskNode {
    Task task;
    TaskNode next;

    public TaskNode(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManager {
    private TaskNode head = null;

    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Task added.");
    }

    public void searchTask(int id) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.taskId == id) {
                System.out.println("Task Found: " + current.task);
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.task.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        TaskNode current = head;
        while (current.next != null && current.next.task.taskId != id) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.addTask(new Task(1, "Design UI", "Pending"));
        manager.addTask(new Task(2, "Develop Backend", "In Progress"));
        manager.addTask(new Task(3, "Test Application", "Pending"));

        System.out.println("\nAll Tasks:");
        manager.displayTasks();

        System.out.println("\nSearch Task with ID 2:");
        manager.searchTask(2);

        System.out.println("\nDelete Task with ID 1:");
        manager.deleteTask(1);

        System.out.println("\nTasks after deletion:");
        manager.displayTasks();
    }
}
