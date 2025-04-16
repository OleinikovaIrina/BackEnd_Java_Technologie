import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer implements Runnable {

   private int timeout = 2;

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
            try {
                Thread.sleep(timeout *1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
