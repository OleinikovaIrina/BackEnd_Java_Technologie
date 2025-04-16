import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");

        Scanner scanner = new Scanner(System.in);

        Timer timer = new Timer();
        Thread thread = new Thread(timer);

       //thread.setDaemon(true);
        thread.start();

        while (true) {
            System.out.println("Input time-out or press q for stop");
            String str = scanner.nextLine();
            if (str.equals("q")) {
                break;
            } else {
                try {
                    timer.setTimeout(Integer.parseInt(str));
                } catch (Exception e) {
                    timer.setTimeout(3);
                }
            }
            System.out.println("Main finish");

        }
    }
}