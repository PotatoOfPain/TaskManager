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

    @Override
    public int hashCode() {
        return Objects.hash(name, description, taskId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        Task newObject = (Task) obj;
        return Objects.equals(this.name, newObject.name) && Objects.equals(this.description, newObject.description)
                && Objects.equals(this.taskId, newObject.taskId);
    }

    @Override
    public String toString(){
        String info =  this.getClass().toString()+ "{" +
                "mame = " + this.name +
                ", description = " + this.description +
                ", taskStatus = " + this.taskStatus +
                ", taskId = " + this.taskId;
        if(this.getClass().equals(Subtask.class)){
            info += ",epicid = " + ((Subtask) this).epicId + "}";
        } else info += "}";
        return info;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
