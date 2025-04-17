public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Реализовать 2 потока:
//        первый поток должен выводить на экран все числа, которые делятся на 2;
//        второй поток должен выводить все числа которые делятся на 3;
//        Main должен запускать оба эти потока, засыпать на 3 секунды
//        и завершать выполнение программы (т.е. оба потока тоже должны прекратить свою работу)

        MyThread thread1 = new MyThread(100, 2);
        MyThread thread2 = new MyThread(100, 3);

        thread1.start();
        thread2.start();


        Thread.sleep(3000);

        thread1.interrupt();
        thread2.interrupt();
        thread1.join();
        thread2.join();
        System.out.println("Finish main");
    }
}