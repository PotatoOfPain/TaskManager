package ru.practicum.model;

public class Subtask extends Task{
    protected final int epicId;

    public Subtask(String name, String description, TaskStatus taskStatus, int epicId){
        super(name, description, taskStatus);
        this.epicId = epicId;
    }

    public Subtask(String name, String description, int epicId){
        super(name, description);
        this.epicId = epicId;
    }

    @Override
    public String toString(){
        return getClass()+ "{" +
                "name = " + name +
                ", description = " + description +
                ", taskStatus = " + taskStatus +
                ", taskId = " + taskId +
                ", epicId = " +
                epicId + "}";
    }

    public int getEpicId() {
        return epicId;
    }
}
