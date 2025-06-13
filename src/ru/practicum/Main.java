package ru.practicum;
import ru.practicum.manager.TasksManager;
import ru.practicum.model.*;

public class Main {

    public static void main (String[] args){
        TasksManager tasksManager = new TasksManager();

        tasksManager.addNewTask(new Task("1", "1"));
        tasksManager.addNewEpic(new Epic ("2", "2"));
        tasksManager.addNewSubtask(new Subtask("3", "3", 2));

        System.out.println("////CHECK OUT FOR PRINTING ALL TASKS, EPICS, SUBS////");
        System.out.println(tasksManager.getAllTasks());
        System.out.println(tasksManager.getALLEpics());
        System.out.println(tasksManager.getAllSubtasks());
        System.out.println("//////////////////////////////////////////////////");
        System.out.println();

        System.out.println("////CHECK OUT FOR PRINTING ALL EPIC SUBS////");
        System.out.println(tasksManager.getEpicSubtasks(2));
        System.out.println("////CHECK OUT WITH WRONG ID////");
        System.out.println(tasksManager.getEpicSubtasks(999));
        System.out.println("//////////////////////////////////////////////////");
        System.out.println();

        System.out.println("////CHECK OUT FOR GETTING NEEDED TASK, EPIC, SUB////");
        System.out.println(tasksManager.getTask(1));
        System.out.println(tasksManager.getEpic(2));
        System.out.println(tasksManager.getSubtask(3));
        System.out.println("////CHECK OUT WITH WRONG IDs////");
        System.out.println(tasksManager.getTask(999));
        System.out.println(tasksManager.getEpic(999));
        System.out.println(tasksManager.getSubtask(999));
        System.out.println("//////////////////////////////////////////////////");
        System.out.println();

        System.out.println("////CHECK OUT FOR REMOVING TASKS, EPICS, SUBS////");
        System.out.println("////PRINTING ALL TASKS, EPICS, SUBS////");
        System.out.println(tasksManager.getAllTasks());
        System.out.println(tasksManager.getALLEpics());
        System.out.println(tasksManager.getAllSubtasks());
        System.out.println("////REMOVING AND CHECK////");
        tasksManager.removeTask(1);
        tasksManager.removeSubtask(3);
        tasksManager.removeEpic(2);
        System.out.println(tasksManager.getAllTasks());
        System.out.println(tasksManager.getALLEpics());
        System.out.println(tasksManager.getAllSubtasks());
        System.out.println("////CHECK OUT FOR CRASHES WITH WRONG IDs////");
        tasksManager.removeTask(999);
        tasksManager.removeSubtask(999);
        tasksManager.removeEpic(999);
        System.out.println("//////////////////////////////////////////////////");
        System.out.println();

        System.out.println("////CHECK OUT FOR REMOVING ALL TASKS, EPICS, SUBTASKS LISTS////");
        tasksManager.addNewTask(new Task("1", "1"));
        tasksManager.addNewEpic(new Epic ("2", "2"));
        tasksManager.addNewSubtask(new Subtask("3", "3", 5));
        System.out.println("////PRINTING ALL TASKS, EPICS, SUBS////");
        System.out.println(tasksManager.getAllTasks());
        System.out.println(tasksManager.getALLEpics());
        System.out.println(tasksManager.getAllSubtasks());
        System.out.println("////REMOVING AND CHECK////");
        tasksManager.clearTasksList();
        tasksManager.clearSubtasksList();
        tasksManager.clearEpicsList();
        System.out.println(tasksManager.getAllTasks());
        System.out.println(tasksManager.getALLEpics());
        System.out.println(tasksManager.getAllSubtasks());
        System.out.println("////CHECK OUT FOR CRASHES WITH EMPTY LISTS////");
        tasksManager.clearTasksList();
        tasksManager.clearSubtasksList();
        tasksManager.clearEpicsList();
        System.out.println("//////////////////////////////////////////////////");
        System.out.println();

        System.out.println("////CHECK OUT FOR UPDATING TASKS, EPICS, SUBTASKS LISTS////");
        tasksManager.addNewTask(new Task("1", "1"));
        tasksManager.addNewEpic(new Epic ("2", "2"));
        tasksManager.addNewSubtask(new Subtask("3", "3", 8));
        System.out.println("////PRINTING ALL TASKS, EPICS, SUBS////");
        System.out.println(tasksManager.getAllTasks());
        System.out.println(tasksManager.getALLEpics());
        System.out.println(tasksManager.getAllSubtasks());
        System.out.println("////UPDATING AND CHECK////");
        Task taskForUpdate = tasksManager.getTask(7);
        taskForUpdate.setName("777");
        taskForUpdate.setDescription("777");
        tasksManager.updateTask(taskForUpdate);
        Epic epicForUpdate = tasksManager.getEpic(8);
        epicForUpdate.setName("888");
        epicForUpdate.setDescription("888");
        tasksManager.updateEpic(epicForUpdate);
        Subtask subtaskForUpdate = tasksManager.getSubtask(9);
        subtaskForUpdate.setName("999");
        subtaskForUpdate.setDescription("999");
        tasksManager.updateSubtask(subtaskForUpdate);
        System.out.println(tasksManager.getAllTasks());
        System.out.println(tasksManager.getALLEpics());
        System.out.println(tasksManager.getAllSubtasks());
        System.out.println("////CHECK OUT FOR CRASHES AND CHANGES APPLIQUED WITH WRONG IDs////");
        Task taskForUpdate2 = tasksManager.getTask(999);
        if(tasksManager.getTask(999) != null){
            taskForUpdate2.setName("000");
            taskForUpdate2.setDescription("000");
        }
        tasksManager.updateTask(taskForUpdate2);

        Epic epicForUpdate2 = tasksManager.getEpic(999);
        if(tasksManager.getEpic(999)!= null){
            epicForUpdate2.setName("000");
            epicForUpdate2.setDescription("000");
        }
        tasksManager.updateEpic(epicForUpdate2);

        Subtask subtaskForUpdate2 = tasksManager.getSubtask(999);
        if(tasksManager.getSubtask(999) != null){
            subtaskForUpdate2.setName("000");
            subtaskForUpdate2.setDescription("000");
        }
        tasksManager.updateSubtask(subtaskForUpdate2);

        System.out.println(tasksManager.getAllTasks());
        System.out.println(tasksManager.getALLEpics());
        System.out.println(tasksManager.getAllSubtasks());

        System.out.println("////CHECK OUT FOR CALCULATING EPICS STATUSES////");
        tasksManager.clearTasksList();
        tasksManager.clearSubtasksList();
        tasksManager.clearEpicsList();
        tasksManager.addNewEpic(new Epic ("1", "1"));
        tasksManager.addNewEpic(new Epic ("1", "1"));
        tasksManager.addNewEpic(new Epic ("1", "1"));
        System.out.println(tasksManager.getEpic(10).getTaskStatus());
        System.out.println(tasksManager.getEpic(11).getTaskStatus());
        System.out.println(tasksManager.getEpic(12).getTaskStatus());
        System.out.println("//////////////////////////////////////////////////");
        tasksManager.addNewSubtask(new Subtask("3", "3",TaskStatus.NEW, 10 ));
        tasksManager.addNewSubtask(new Subtask("3", "3", TaskStatus.DONE, 11));
        tasksManager.addNewSubtask(new Subtask("3", "3",TaskStatus.IN_PROGRESS, 12));
        System.out.println(tasksManager.getEpic(10).getTaskStatus());
        System.out.println(tasksManager.getEpic(11).getTaskStatus());
        System.out.println(tasksManager.getEpic(12).getTaskStatus());
        System.out.println("//////////////////////////////////////////////////");
        Subtask updatingStatus1 = tasksManager.getSubtask(13);
        updatingStatus1.setTaskStatus(TaskStatus.DONE);
        tasksManager.updateSubtask(updatingStatus1);

        Subtask updatingStatus2 = tasksManager.getSubtask(14);
        updatingStatus2.setTaskStatus(TaskStatus.IN_PROGRESS);
        tasksManager.updateSubtask(updatingStatus2);

        Subtask updatingStatus3 = tasksManager.getSubtask(15);
        updatingStatus3.setTaskStatus(TaskStatus.NEW);
        tasksManager.updateSubtask(updatingStatus3);

        System.out.println(tasksManager.getEpic(10).getTaskStatus());
        System.out.println(tasksManager.getEpic(11).getTaskStatus());
        System.out.println(tasksManager.getEpic(12).getTaskStatus());
        System.out.println("//////////////////////////////////////////////////");
        tasksManager.clearSubtasksList();
        System.out.println(tasksManager.getEpic(10).getTaskStatus());
        System.out.println(tasksManager.getEpic(11).getTaskStatus());
        System.out.println(tasksManager.getEpic(12).getTaskStatus());





    }
}
