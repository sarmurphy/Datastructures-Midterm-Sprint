public class Task {
    private String description;
    private Boolean isComplete;
    Task next;

    public Task(String description) {
        this.description = description;
        this.isComplete = false;
        this.next = null;
    }

    public void markComplete() {
        this.isComplete = true;
    }

    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    @Override
    public String toString() {
        return description + ": " + (isComplete ? "Complete" : "Incomplete");
    }
}
