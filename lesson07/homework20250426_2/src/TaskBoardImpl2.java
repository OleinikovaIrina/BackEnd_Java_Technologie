
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


    public class TaskBoardImpl2 implements TaskBoard {
    private BlockingQueue<String> tasksQueue;
    private static final int limitTask = 6;

    public TaskBoardImpl2() {
        tasksQueue = new ArrayBlockingQueue<>(limitTask);
    }

    @Override
    public void setTasks(List<String> taskToAdd) throws InterruptedException {
        for (String task : taskToAdd) {
            tasksQueue.put(task);
        }

    }

    @Override
    public String getTask() throws InterruptedException {
        return tasksQueue.take();
    }
}