package ru.practicum.model;

public class Subtask extends Task{
    protected int epicId;

    public Subtask(String name, String description, TaskStatus taskStatus, int epicId){
        super(name, description, taskStatus);
        this.epicId = epicId;
    }

    public Subtask(String name, String description, int epicId){
        super(name, description);
        this.epicId = epicId;
    }

    public Subtask(String name, String description){
        super(name, description);
    }

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }

}
