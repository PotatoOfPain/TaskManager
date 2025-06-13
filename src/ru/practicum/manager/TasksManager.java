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
        return new ArrayList<>(epics.values());
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
        return tasks.get(taskId);
    }

    public Subtask getSubtask(int subtaskId){
        return subtasks.getOrDefault(subtaskId, null);
    }

    public Epic getEpic(int epicId){
        return epics.getOrDefault(epicId, null);
    }

    public void updateTask(Task newTask){
        if(newTask != null && tasks.containsKey(newTask.getTaskId())){
            tasks.put(newTask.getTaskId(), newTask);
        }
    }

    public void updateEpic(Epic newEpic){
        if(newEpic != null && epics.containsKey(newEpic.getTaskId())){
            epics.get(newEpic.getTaskId()).setName(newEpic.getName());
            epics.get(newEpic.getTaskId()).setDescription(newEpic.getDescription());
        }
    }

    public void updateSubtask(Subtask newSubtask){
        if(newSubtask != null && subtasks.containsKey(newSubtask.getTaskId())){
            subtasks.put(newSubtask.getTaskId(), newSubtask);
            calculateStatus(newSubtask.getEpicId());
        }
    }

    public void removeTask(int taskId){
        tasks.remove(taskId);
    }

    public void removeEpic(int epicId){
        if(epics.containsKey(epicId) && !epics.get(epicId).getSubtasks().isEmpty()){
            for(Integer epicSubtaskId : epics.get(epicId).getSubtasks()){
                subtasks.remove(epicSubtaskId);
            }
        }
        epics.remove(epicId);
    }

    public void removeSubtask(int subtaskId){
        if(subtasks.containsKey(subtaskId)){
            int epicID = subtasks.get(subtaskId).getEpicId();
            epics.get(epicID).removeSubtaskFromEpic(subtaskId);
            subtasks.remove(subtaskId);
            calculateStatus(epicID);
        }

    }

    public void clearTasksList(){
         tasks.clear();
    }

    public void clearEpicsList(){
        epics.clear();
        clearSubtasksList();
    }

    public void clearSubtasksList(){
        subtasks.clear();
        for(Epic epic : epics.values()){
            epic.setSubtasks(new ArrayList<>());
            calculateStatus(epic.getTaskId());
        }
    }

    private void calculateStatus(int epicId){
        ArrayList<TaskStatus> taskStatusArrayList = new ArrayList<>();
        int newTask = 0;
        int taskInProgress = 0;
        int taskDone = 0;

        if(epics.get(epicId).getSubtasks().isEmpty()){
            epics.get(epicId).setTaskStatus(TaskStatus.NEW);
        } else {
            for(Integer subId : epics.get(epicId).getSubtasks()){
                taskStatusArrayList.add(subtasks.get(subId).getTaskStatus());
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
}
