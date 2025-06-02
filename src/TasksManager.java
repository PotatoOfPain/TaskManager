import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TasksManager {
    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();
    HashMap<Integer, Subtask> subtasks = new HashMap<>();

    public void startTask(Object newObject){
        if(newObject.getClass().equals(Epic.class)){
            epics.put(newObject.hashCode(), (Epic) newObject);
        } else if (newObject.getClass().equals(Task.class)) {
            tasks.put(newObject.hashCode(), (Task) newObject);
        } else {
            subtasks.put(newObject.hashCode(), (Subtask) newObject);
        }
    }

    public void addSubtaskToTask(int taskHashCode, int subtaskHashCode){
        if(tasks.containsKey(taskHashCode) && subtasks.containsKey(subtaskHashCode)){
            Epic newEpic = new Epic(tasks.get(taskHashCode));
            newEpic.addSubtask(subtaskHashCode);
            tasks.remove(taskHashCode);
            epics.put(newEpic.hashCode(), newEpic);
        } else if (epics.containsKey(taskHashCode) && subtasks.containsKey(subtaskHashCode)) {
            epics.get(taskHashCode).addSubtask(subtaskHashCode);
        }
    }

    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> allTasks = new ArrayList<Task>();
        allTasks.addAll(tasks.values());
        allTasks.addAll(epics.values());
        return allTasks;
    }

    public ArrayList<Epic> getALLEpics() {
        return new ArrayList<Epic>(epics.values());
    }

    public ArrayList<Subtask> getEpicSubtasks(int epicHashCode) {
         if(!epics.isEmpty() && epics.containsKey(epicHashCode)){
             ArrayList<Subtask> epicsSubtasksList = new ArrayList<>();
             for(Integer subtaskHashCode : subtasks.keySet()){
                 for(Integer epicSubtaskHashCode : epics.get(epicHashCode).getSubtasks()){
                     if(Objects.equals(subtaskHashCode, epicSubtaskHashCode)){
                        epicsSubtasksList.add(subtasks.get(epicSubtaskHashCode));
                     }
                 }
             }
             return epicsSubtasksList;
         } else return null;
    }

    public void clearTasksList(){
         tasks.clear();
    }

    public void clearEpicsList(){
        epics.clear();
    }

    public void clearSubtasksList(){
        if(!epics.isEmpty()){
            for(Epic epic : epics.values()){
                epic.setSubtasks(new ArrayList<>());
            }
        }
        subtasks.clear();
    }

    public void clearAllTasks(){
        tasks.clear();
        subtasks.clear();
        epics.clear();
    }

    public void removeTask(int hashCode){
         tasks.remove(hashCode);
    }

    public void clearEpicSubtasks(int hashCode){
         for(Subtask subtask : subtasks.values()){
             for(Integer subtaskHashCode : epics.getOrDefault(hashCode, null).getSubtasks()){
                 if(Objects.equals(subtask.hashCode(), subtaskHashCode)){
                     subtasks.remove(subtaskHashCode);
                 }
             }
         }
        epics.getOrDefault(hashCode, null).setSubtasks(new ArrayList<>());
    }

    public Task findTask(int hashCode){
        if(tasks.containsKey(hashCode)){
            return tasks.get(hashCode);
        } else if (epics.containsKey(hashCode)) {
            return epics.get(hashCode);
        } else return subtasks.getOrDefault(hashCode, null);
    }

    public void updateTask(int hashCode, Task newTask){
         Task oldTask = findTask(hashCode);
         oldTask.setName(newTask.getName());
         oldTask.setDescription(newTask.getDescription());
    }

    public TaskStatus getTaskStatus(int hashCode){
        if(findTask(hashCode).getClass().equals(Epic.class)){
            calculateStatus(hashCode);
            return findTask(hashCode).getTaskStatus();
        } else return findTask(hashCode).getTaskStatus();
    }

    public void updateTaskStatus(int hashCode, TaskStatus taskStatus){
         findTask(hashCode).setTaskStatus(taskStatus);
    }


    public void calculateStatus(int epicHashCode){
        ArrayList<TaskStatus> taskStatusArrayList = new ArrayList<>();

        for(Subtask subtask : subtasks.values()){
            for(Integer subtaskHashCode : epics.get(epicHashCode).getSubtasks()){
                if(subtask.hashCode() == subtaskHashCode){
                    taskStatusArrayList.add(subtask.getTaskStatus());
                }
            }
        }

        int statusCounter = 0;
        for(TaskStatus taskStatus : taskStatusArrayList){
            if(taskStatus.equals(TaskStatus.DONE)){
                statusCounter++;
            }
            if(taskStatus.equals(TaskStatus.IN_PROGRESS)){
                statusCounter--;
            }

        }
        if(statusCounter == 0){
            epics.get(epicHashCode).setTaskStatus(TaskStatus.NEW);
        } else if (statusCounter == taskStatusArrayList.size()) {
            epics.get(epicHashCode).setTaskStatus(TaskStatus.DONE);
        } else epics.get(epicHashCode).setTaskStatus(TaskStatus.IN_PROGRESS);
    }
}
