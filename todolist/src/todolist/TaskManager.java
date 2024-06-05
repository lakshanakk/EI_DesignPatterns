package todolist;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
    private List<Task> tasks;
    private List<Memento> history;
    private int currentState;

    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.history = new ArrayList<>();
        this.currentState = -1;
        saveState();
    }

    public void addTask(Task task) {
        tasks.add(task);
        saveState();
    }

    public void markTaskCompleted(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.markCompleted();
                saveState();
                break;
            }
        }
    }

    public void deleteTask(String description) {
        tasks.removeIf(task -> task.getDescription().equalsIgnoreCase(description));
        saveState();
    }

    public List<Task> viewTasks(String filter) {
        switch (filter.toLowerCase()) {
            case "show completed":
                return tasks.stream().filter(Task::isCompleted).collect(Collectors.toList());
            case "show pending":
                return tasks.stream().filter(task -> !task.isCompleted()).collect(Collectors.toList());
            case "show all":
            default:
                return new ArrayList<>(tasks);
        }
    }

    private void saveState() {
        if (currentState != history.size() - 1) {
            history = history.subList(0, currentState + 1);
        }
        history.add(new Memento(new ArrayList<>(tasks)));
        currentState++;
    }

    public void undo() {
        if (currentState > 0) {
            currentState--;
            tasks = new ArrayList<>(history.get(currentState).getSavedState());
        }
    }

    public void redo() {
        if (currentState < history.size() - 1) {
            currentState++;
            tasks = new ArrayList<>(history.get(currentState).getSavedState());
        }
    }

    private static class Memento {
        private final List<Task> state;

        public Memento(List<Task> state) {
            this.state = state;
        }

        public List<Task> getSavedState() {
            return state;
        }
    }
}