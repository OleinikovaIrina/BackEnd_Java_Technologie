import java.util.List;

public interface TaskBoard {

    String getTask() throws InterruptedException;
    void setTasks(List<String> tasks) throws InterruptedException;
}
