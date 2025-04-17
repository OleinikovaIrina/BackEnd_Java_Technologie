public class MyThread extends Thread {

    private int count;
    private int divisor;

    public MyThread(int count, int divisor) {
        this.count = count;
        this.divisor = divisor;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Thread " + name + " start");




            for (int i = 0; i < count; i++) {

                if (isInterrupted()) {
                    System.out.println("Поток " + name + " прерван");
                    return;
                }
                if (i % divisor == 0) {
                    System.out.println("Поток c числами, делящимися на " + divisor + " " + i);

                }
                try {
                    Thread.sleep(1000); // Поток засыпает
                } catch (InterruptedException e) {
                    System.out.println("Поток " + name + "прерван во время сна!");
                break;
                }
            }
        }

    }
