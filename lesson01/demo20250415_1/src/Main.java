public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        MyThread thread1 = new MyThread("Jack");
        MyThread thread2 = new MyThread("Nick");
        MyThread thread3 = new MyThread("Zina");

        thread1.start();  /// not run() !!!
        thread2.start();
        thread3.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main: " + i);
        }

        System.out.println("-------- finish main");
    }
}


