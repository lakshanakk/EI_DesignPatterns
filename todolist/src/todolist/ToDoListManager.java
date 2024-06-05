package todolist;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ToDoListManager {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("\nChoose an action: add, complete, delete, view, undo, redo, exit");
            String action = scanner.nextLine().trim().toLowerCase();

            switch (action) {
                case "add":
                    System.out.println("Enter task description:");
                    String description = scanner.nextLine().trim();
                    
                    System.out.println("Enter due date (yyyy-MM-dd) or press Enter to skip:");
                    String dueDateInput = scanner.nextLine().trim();
                    LocalDate dueDate = dueDateInput.isEmpty() ? null : LocalDate.parse(dueDateInput, formatter);
                    
                    System.out.println("Enter tags (comma separated) or press Enter to skip:");
                    String tags = scanner.nextLine().trim();

                    Task task = new Task.Builder(description)
                            .dueDate(dueDate)
                            .tags(tags.isEmpty() ? null : tags)
                            .build();
                    taskManager.addTask(task);
                    break;

                case "complete":
                    System.out.println("Enter task description to mark as completed:");
                    String completeDescription = scanner.nextLine().trim();
                    taskManager.markTaskCompleted(completeDescription);
                    break;

                case "delete":
                    System.out.println("Enter task description to delete:");
                    String deleteDescription = scanner.nextLine().trim();
                    taskManager.deleteTask(deleteDescription);
                    break;

                case "view":
                    System.out.println("View tasks: show all, show completed, show pending");
                    String filter = scanner.nextLine().trim().toLowerCase();
                    List<Task> tasks = taskManager.viewTasks(filter);
                    printTasks(tasks);
                    break;

                case "undo":
                    taskManager.undo();
                    System.out.println("Undo the last action.");
                    break;

                case "redo":
                    taskManager.redo();
                    System.out.println("Redo the last undone action.");
                    break;

                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid action. Please try again.");
                    break;
            }
        }
    }

    private static void printTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}