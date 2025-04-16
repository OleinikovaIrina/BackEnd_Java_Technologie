public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        String name = Thread.currentThread().getName();
        Long id = Thread.currentThread().getId();
        System.out.println(name + " " + id + "start");


        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "  " + "start анонимный класс");
            }
        };


        Thread[] threads = {

                new MyThread(),
                new MyThread(),
                new Thread(new MyRunnable()),
                new Thread(() -> {
                    System.out.println(Thread.currentThread().getName() + "  " + "start Lambda");
                }),

                thread1

        };
        for (Thread thread : threads) {
            thread.start();

        }

        Thread.sleep(1000);
        System.out.println(name + id + " Finish");

    }
}