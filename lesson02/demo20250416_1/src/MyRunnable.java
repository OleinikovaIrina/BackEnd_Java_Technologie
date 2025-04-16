public class MyRunnable implements  Runnable{


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Thread " + name + " start");

        for (int i = 0; i < 5; i++) {
            System.out.println("(i)" + name + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println( " ( i ) Thread" + name +  "finish");
    }
}

