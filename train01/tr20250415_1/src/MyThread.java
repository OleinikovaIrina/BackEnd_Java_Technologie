public class MyThread extends Thread {
    private int count;

    public MyThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {

            if (isInterrupted()) {
                System.out.println("Поток остановлен досрочно");
                return; // вот здесь — поток завершает свою работу
            }
            System.out.println("Тик");


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Поток прерван во время сна");
                return;
            }

        }
    }
}

