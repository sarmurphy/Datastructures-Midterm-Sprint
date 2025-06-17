public class TaskList {
    private Task head;

    public TaskList() {
        this.head = null;
    }

    // Adding a new task
    public void addTask(String description) {
        Task newTask = new Task(description);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
    }

    // Marking a task as completed
    public boolean markAsComplete(String description) {
        Task current = head;
        while (current != null) {
            if (current.getDescription().equals(description)) {
                current.markComplete();
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Displaying tasks and completion status
    public void printTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current.getDescription() + ": " + (current.isComplete() ? "Complete" : "Incomplete"));
        }
    }
}
