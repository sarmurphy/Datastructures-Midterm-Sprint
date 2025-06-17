import java.util.Scanner;

public class Main {
    private static User[] users = new User[5]; // Number of users allowed
    private static int userCount = 0;

    // Adding a new user
    public static void addUser(String name) {
        if (userCount >= users.length) {
            System.out.println("Limit reached. Unable to add new user.");
            return;
        }
        users[userCount++] = new User(name);
        System.out.println("User " + name + " added successfully!");
    }

    // Finding a user by name
    public static User getUser(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                return users[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("To-Do List Manager");
            System.out.println("1. Add a User");
            System.out.println("2. Add a Task");
            System.out.println("3. Mark a Task as Completed");
            System.out.println("4. View All Tasks");
            System.out.println("5. Exit Program");
            System.out.println("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Adding a new user
                    if (userCount < users.length) {
                        System.out.println("Enter username: ");
                        String name = scanner.nextLine();
                        users[userCount++] = new User(name);
                        System.out.println("User added successfully!");
                    } else {
                        System.out.println("User limit reached. Unable to add new user.");
                    }
                    break;

                case 2: // Adding a new task
                    System.out.println("Enter username: ");
                    String userName = scanner.nextLine();
                    User user = findUser(users, userName, userCount);
                    if (user != null) {
                        System.out.println("Enter task description: ");
                        String taskDescription = scanner.nextLine();
                        user.addTask(taskDescription);
                        System.out.println("Task added successfully!");
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 3: // Marking a task as complete
                    System.out.println("Enter username: ");
                    userName = scanner.nextLine();
                    user = findUser(users, userName, userCount);
                    if (user != null) {
                        System.out.println("Enter task description to mark as complete: ");
                        String taskDescription = scanner.nextLine();
                        user.markAsComplete(taskDescription);
                        System.out.println("Task marked as complete!");
                    } else {
                        System.out.println("Unable to complete task. User not found.");
                    }
                    break;

                case 4: // Viewing all tasks for a user
                    System.out.println("Enter username: ");
                    userName = scanner.nextLine();
                    user = findUser(users, userName, userCount);
                    if (user != null) {
                        user.printTasks();
                    } else {
                        System.out.println("Unable to view tasks. User not found.");
                    }
                    break;

                case 5: // Exiting the program
                    System.out.println("Exit");
                    scanner.close();
                    return;

                default:
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static User findUser(User[] users, String name, int count) {
        for (int i = 0; i < count; i++) {
            if (users[i].getName().equals(name)) {
                return users[i];
            }
        }
        return null;
    }
        
    }

