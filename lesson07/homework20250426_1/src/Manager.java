import java.util.ArrayList;
import java.util.List;

public class Manager implements Runnable {
    private TaskBoard taskBoard;
    private int nTask;

    public Manager(TaskBoard taskBoard, int nTask) {
        this.taskBoard = taskBoard;
        this.nTask = nTask;
    }


    @Override
    public void run() {
        List<String> taskList = new ArrayList<>();
        for (int i = 0; i < nTask; i++) {
            taskList.add("task " + i);
        }
        taskBoard.setTasks(taskList);
    }
}
