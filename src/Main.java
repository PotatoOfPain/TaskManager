public class Main {

    public static void main (String[] args){
        TasksManager tasksManager = new TasksManager();


        //Далее тестирование функционала
        tasksManager.startTask(new Epic("1", "2"));
        tasksManager.startTask(new Subtask("3", "4"));
        tasksManager.startTask(new Task("5", "6"));
        tasksManager.startTask(new Task("5", "6"));
        tasksManager.startTask(new Task("6", "7"));

        System.out.println("Check of correct recording");
        System.out.println("////////////////////////////");
        System.out.println(tasksManager.getAllTasks());
        System.out.println("////////////////////////////");
        System.out.println();

        System.out.println("Looking for hash codes in hash map");
        System.out.println("////////////////////////////");
        System.out.println(tasksManager.tasks.keySet());
        System.out.println(tasksManager.epics.keySet());
        System.out.println(tasksManager.subtasks.keySet());
        System.out.println("////////////////////////////");
        System.out.println();

        System.out.println("Check of correct adding of subtask to task");
        System.out.println("////////////////////////////");
        System.out.println(tasksManager.getAllTasks());
        tasksManager.addSubtaskToTask(2690, 2594);
        System.out.println(tasksManager.getAllTasks());
        System.out.println("////////////////////////////");
        System.out.println();

        System.out.println("Check of showing only epics");
        System.out.println("////////////////////////////");
        System.out.println(tasksManager.getALLEpics());
        System.out.println(tasksManager.epics.keySet());
        System.out.println("////////////////////////////");
        System.out.println();

        System.out.println("Check of showing epic subtask");
        System.out.println("////////////////////////////");
        System.out.println(tasksManager.getEpicSubtasks(2690));
        System.out.println("////////////////////////////");
        System.out.println();

       System.out.println("Check of finding feature");
        System.out.println("////////////////////////////");
        System.out.println(tasksManager.epics.get(2690));
        System.out.println(tasksManager.findTask(2690));
        System.out.println("////////////////////////////");
        System.out.println();

        System.out.println("Check of updating feature");
        System.out.println("////////////////////////////");
        System.out.println(tasksManager.findTask(2658));
        tasksManager.updateTask(2658, new Task("o", "p"));
        System.out.println(tasksManager.getAllTasks());
        System.out.println("////////////////////////////");
        System.out.println();

        System.out.println("Check of clearing subtask from epic feature");
        System.out.println("////////////////////////////");
        System.out.println(tasksManager.getEpicSubtasks(2690));
        tasksManager.clearEpicSubtasks(2690);
        System.out.println(tasksManager.getEpicSubtasks(2690));
        System.out.println("////////////////////////////");
        System.out.println();



        System.out.println("Check of removing task feature");
        System.out.println("////////////////////////////");
        System.out.println(tasksManager.getAllTasks());
        tasksManager.removeTask(2658);
        System.out.println(tasksManager.getAllTasks());
        System.out.println("////////////////////////////");
        System.out.println();

        System.out.println("Check of removing all epics feature");
        System.out.println("////////////////////////////");
        System.out.println(tasksManager.getAllTasks());
        tasksManager.clearEpicsList();
        System.out.println(tasksManager.getAllTasks());
        System.out.println("////////////////////////////");
        System.out.println();

        tasksManager.startTask(new Epic("1", "2"));
        tasksManager.startTask(new Subtask("3", "4"));
        tasksManager.startTask(new Task("5", "6"));
        tasksManager.startTask(new Task("6", "7"));

        System.out.println("Check of removing only tasks feature");
        System.out.println("////////////////////////////");
        System.out.println(tasksManager.getAllTasks());
        tasksManager.clearTasksList();
        System.out.println(tasksManager.getAllTasks());
        System.out.println("////////////////////////////");
        System.out.println();

        tasksManager.startTask(new Epic("1", "2"));
        tasksManager.startTask(new Subtask("3", "4"));
        tasksManager.startTask(new Task("5", "6"));
        tasksManager.startTask(new Task("6", "7"));

        System.out.println("Check of removing all tasks epic, and subtasks feature");
        System.out.println("////////////////////////////");
        System.out.println(tasksManager.getAllTasks());
        tasksManager.clearAllTasks();
        System.out.println(tasksManager.getAllTasks());
        System.out.println("////////////////////////////");
        System.out.println();

        tasksManager.startTask(new Subtask("3", "4"));

        System.out.println("Check of removing all subtasks feature");
        System.out.println("////////////////////////////");
        System.out.println(tasksManager.subtasks);
        tasksManager.clearSubtasksList();
        System.out.println(tasksManager.subtasks);
        System.out.println("////////////////////////////");
        System.out.println();

        System.out.println("Check of showing and changing status feature");
        System.out.println("////////////////////////////");
        tasksManager.startTask(new Epic("1", "2"));
        tasksManager.startTask(new Epic("19", "5"));
        tasksManager.startTask(new Task("5", "6"));
        tasksManager.startTask(new Subtask("3", "4"));
        tasksManager.startTask(new Subtask("56", "4"));
        tasksManager.startTask(new Subtask("89", "4"));

        System.out.println(tasksManager.epics.keySet());
        System.out.println(tasksManager.tasks.keySet());
        System.out.println(tasksManager.subtasks.keySet());
        tasksManager.addSubtaskToTask(2530, 2594);
        tasksManager.addSubtaskToTask(49870, 53620);
        tasksManager.addSubtaskToTask(49870, 56596);
        System.out.println("////////////////////////////");
        System.out.println(tasksManager.getTaskStatus(2530));
        System.out.println(tasksManager.getTaskStatus(49870));
        System.out.println(tasksManager.getTaskStatus(2658));
        System.out.println("////////////////////////");
        tasksManager.updateTaskStatus(2594, TaskStatus.DONE);
        tasksManager.updateTaskStatus(53620, TaskStatus.IN_PROGRESS);
        tasksManager.updateTaskStatus(2594, TaskStatus.DONE);
        System.out.println(tasksManager.getTaskStatus(2530));
        System.out.println(tasksManager.getTaskStatus(49870));
        System.out.println(tasksManager.getTaskStatus(2658));
        System.out.println("////////////////////////////");
    }
}
