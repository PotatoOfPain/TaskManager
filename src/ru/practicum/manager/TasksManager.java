package ru.practicum.manager;
import ru.practicum.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TasksManager {
    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, Epic> epics = new HashMap<>();
    private final HashMap<Integer, Subtask> subtasks = new HashMap<>();
    private int idCounter = 1;

    public void addNewTask(Task task){
        task.setTaskId(idCounter);
        tasks.put(idCounter, task);
        idCounter++;
    }

    public void addNewEpic(Epic epic){
        epic.setTaskId(idCounter);
        epics.put(idCounter, epic);
        idCounter++;
    }

    public void addNewSubtask(Subtask subtask){
        if(epics.containsKey(subtask.getEpicId())){
            subtask.setTaskId(idCounter);
            epics.get(subtask.getEpicId()).getSubtasks().add(subtask.getTaskId());
            subtasks.put(idCounter, subtask);
            calculateStatus(subtask.getEpicId());
            idCounter++;
        } else return;
    }

    public ArrayList<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public ArrayList<Epic> getALLEpics() {
        return new ArrayList<Epic>(epics.values());
    }

    public ArrayList<Subtask> getAllSubtasks(){
        return new ArrayList<>(subtasks.values());
    }

    public ArrayList<Subtask> getEpicSubtasks(int epicId) {
        if(epics.containsKey(epicId) && !epics.get(epicId).getSubtasks().isEmpty()){
            ArrayList<Subtask> epicsSubtasksList = new ArrayList<>();
            for(Integer subtaskId : epics.get(epicId).getSubtasks()){
                epicsSubtasksList.add(subtasks.get(subtaskId));
            }
            return epicsSubtasksList;
        } else return null;
    }

    public Task getTask(int taskId){
        return tasks.getOrDefault(taskId, null);
    }

    public Subtask getSubtask(int subtaskId){
        return subtasks.getOrDefault(subtaskId, null);
    }

    public Epic getEpic(int epicId){
        return epics.getOrDefault(epicId, null);
    }

    public void updateTask(int taskId, Task newTask){
        if(tasks.containsKey(taskId)){
            tasks.put(taskId, newTask);
        }
    }

    public void updateEpic(int epicId, Epic newEpic){
        if(epics.containsKey(epicId)){
            epics.put(epicId, newEpic);
        }
    }

    public void updateSubtask(int subtaskId, Subtask newSubtask){
        if(subtasks.containsKey(subtaskId)){
            newSubtask.setEpicId(subtasks.get(subtaskId).getEpicId());
            subtasks.put(subtaskId, newSubtask);
        }
    }

    public void removeTask(int taskId){
        tasks.remove(taskId);
    }

    public void removeEpic(int epicId){
        if(epics.containsKey(epicId) && !epics.get(epicId).getSubtasks().isEmpty()){
            ArrayList<Integer> subtasksIdList = new ArrayList<>();
            for(Integer subtaskId : subtasks.keySet()){
                for(Integer epicSubtaskId : epics.get(epicId).getSubtasks()){
                    if(Objects.equals(epicSubtaskId, subtaskId)){
                        subtasksIdList.add(subtaskId);
                    }
                }
            }
            for(Integer id : subtasksIdList){
                subtasks.remove(id);
            }
        }
        epics.remove(epicId);
    }

    public void removeSubtask(int subtaskId){
        if(subtasks.containsKey(subtaskId)){
            epics.get(subtasks.get(subtaskId).getEpicId()).removeSubtaskFromEpic(subtaskId);
            subtasks.remove(subtaskId);
        }

    }

    public void clearTasksList(){
         tasks.clear();
    }

    public void clearEpicsList(){
        epics.clear();
    }

    public void clearSubtasksList(){
        subtasks.clear();
    }

    public void clearAllTasks(){
        tasks.clear();
        subtasks.clear();
        epics.clear();
    }

    public void calculateStatus(int epicId){
        ArrayList<TaskStatus> taskStatusArrayList = new ArrayList<>();
        int newTask = 0;
        int taskInProgress = 0;
        int taskDone = 0;

        for(Integer subtaskId : subtasks.keySet()){
            for(Integer epicSubtaskId : epics.get(epicId).getSubtasks()){
                if(Objects.equals(subtaskId, epicSubtaskId)){
                    taskStatusArrayList.add(subtasks.get(subtaskId).getTaskStatus());
                }
            }
        }

        for(TaskStatus taskStatus : taskStatusArrayList){
            if(taskStatus.equals(TaskStatus.NEW)){
                newTask++;
            } else if(taskStatus.equals(TaskStatus.IN_PROGRESS)){
                taskInProgress++;
            } else taskDone++;
        }

        if(newTask == taskStatusArrayList.size()){
            epics.get(epicId).setTaskStatus(TaskStatus.NEW);
        } else if (taskDone == taskStatusArrayList.size()) {
            epics.get(epicId).setTaskStatus(TaskStatus.DONE);
        } else epics.get(epicId).setTaskStatus(TaskStatus.IN_PROGRESS);



    }
}
