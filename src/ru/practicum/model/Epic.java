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

    public void addSubtask(int subtaskId){
        if(subtasks.contains(subtaskId)){
            return;
        } else subtasks.add(subtaskId);
    }

    public void removeSubtaskFromEpic(int subtaskId){
        for(Integer id : subtasks){
            if(id == subtaskId){
                subtasks.remove(id);
                return;
            }
        }
    }

    public ArrayList<Integer> getSubtasks() {
        return subtasks;
    }
}

