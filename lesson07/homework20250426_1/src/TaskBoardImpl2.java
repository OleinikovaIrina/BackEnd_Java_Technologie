import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskBoardImpl2 implements TaskBoard {
    private List<String> tasks = new ArrayList<>();

    private Lock lock = new ReentrantLock();
    private Condition managerCondition = lock.newCondition();
    private Condition workerCondition = lock.newCondition();


    @Override
    public void setTasks(List<String> taskToAdd) {
        lock.lock();
        try {
            while (!tasks.isEmpty()) {
                managerCondition.await();  // !!!! не wait()
            }
            tasks.addAll(taskToAdd);
            workerCondition.signalAll();      // !!!!  не notify()

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String getTask() {
        lock.lock();
        try {
            while (tasks.isEmpty()) {
                workerCondition.await();
            }
            String result = tasks.remove(0);
            if (tasks.isEmpty()) {
                managerCondition.signal();
            }
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }
}