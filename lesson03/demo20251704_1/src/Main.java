public class Main {
    public static void main(String[] args) {
        Thread task2 = new Task(2);
        Thread task3 = new Task(3);

        task3.setDaemon(true);
        task2.setDaemon(true);

        task2.start();
        task3.start();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}