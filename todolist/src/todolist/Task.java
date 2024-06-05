package todolist;


import java.time.LocalDate;

public class Task {
    private String description;
    private LocalDate dueDate;
    private boolean isCompleted;
    private String tags;

    private Task(Builder builder) {
        this.description = builder.description;
        this.dueDate = builder.dueDate;
        this.isCompleted = builder.isCompleted;
        this.tags = builder.tags;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    public String getTags() {
        return tags;
    }

    public static class Builder {
        private final String description;
        private LocalDate dueDate;
        private boolean isCompleted;
        private String tags;

        public Builder(String description) {
            this.description = description;
        }

        public Builder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder tags(String tags) {
            this.tags = tags;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }

    @Override
    public String toString() {
        return description + (isCompleted ? " - Completed" : " - Pending") + 
               (dueDate != null ? ", Due: " + dueDate : "") + 
               (tags != null ? ", Tags: " + tags : "");
    }
}

