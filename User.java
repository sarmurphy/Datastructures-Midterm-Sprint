public class User {
    private String name;
    private TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public String getName() {
        return name;
    }

    public void addTask(String description) {
        taskList.addTask(description);
    }

    public void markAsComplete(String description) {
        taskList.markAsComplete(description);
    }

    public void printTasks() {
        System.out.println("All tasks for " + name + ": ");
        taskList.printTasks();
    }
}
