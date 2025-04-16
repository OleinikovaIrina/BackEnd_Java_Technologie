public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello, World!");

        MyThread thread = new MyThread(5);
        thread.start();
        Thread.sleep(4500);
        thread.interrupt();
        thread.join();
        System.out.println("Главный поток завершён");


    }


}