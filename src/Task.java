import java.util.Objects;

public class Task {
    private String name;
    private String description;
    private TaskStatus taskStatus = TaskStatus.NEW;

    public Task(String name, String description, TaskStatus taskStatus){
        this.name = name;
        this.description = description;
        this.taskStatus = taskStatus;
    }

    public Task(String name, String description){
        this.name = name;
        this.description = description;
    }

    public TaskStatus getTaskStatus(){
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus newStatus){
        taskStatus = newStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
