import java.util.ArrayList;
import java.util.List;

public class Manager implements Runnable {
    private TaskBoard taskBoard;
    private int limitTask;

    public Manager(TaskBoard taskBoard, int limitTask) {
        this.taskBoard = taskBoard;
        this.limitTask = limitTask;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < limitTask; i++) {
                taskBoard.setTasks(List.of("task " + i));
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}