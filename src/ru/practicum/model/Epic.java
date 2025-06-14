package ru.practicum.model;

import java.util.ArrayList;

public class Epic extends Task{

    private final ArrayList<Integer> subtasks = new ArrayList<>();

    public Epic(String name, String description){
        super(name, description);
    }

    public Epic(Task task){
        super(task.getName(), task.getDescription());
    }

    public void removeSubtaskFromEpic(int subtaskId){
        subtasks.remove(Integer.valueOf(subtaskId));
    }

    public ArrayList<Integer> getSubtasks() {
        return subtasks;
    }

    public void clearSubtasksList(){
        subtasks.clear();
    }

    @Override
    public String toString(){
        return getClass() + "{" +
                "name = " + name +
                ", description = " + description +
                ", taskStatus = " + taskStatus +
                ", taskId = " + taskId +
                ", epic subtasks ids : " + subtasks + "}";
    }
}

