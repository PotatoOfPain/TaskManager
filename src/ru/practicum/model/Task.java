package ru.practicum.model;

import java.util.Objects;

public class Task {
    protected String name;
    protected String description;
    protected TaskStatus taskStatus = TaskStatus.NEW;
    protected int taskId;

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

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        Task newObject = (Task) obj;
        return Objects.equals(this.taskId, newObject.taskId);
    }

    @Override
    public String toString(){
        return getClass().toString() + "{" +
                "mame = " + name +
                ", description = " + description +
                ", taskStatus = " + taskStatus +
                ", taskId = " + taskId;
    }
}
