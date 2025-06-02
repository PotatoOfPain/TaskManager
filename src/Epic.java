import java.util.ArrayList;

public class Epic extends Task{
    private ArrayList<Integer> subtasks = new ArrayList<>();

    public Epic(String name, String description){
        super(name, description);
    }

    public Epic(Task task){
        super(task.getName(), task.getDescription());
    }


    public void addSubtask(int subtaskHashCode){
        if(subtasks.contains(subtaskHashCode)){
            return;
        } else subtasks.add(subtaskHashCode);
        //calculateStatus();
    }

    public ArrayList<Integer> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(ArrayList<Integer> subtasks) {
        this.subtasks = subtasks;
        if(subtasks != null){
            //calculateStatus();
        }

    }


}

