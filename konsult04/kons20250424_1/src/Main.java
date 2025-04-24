public class Main {
    public static void main(String[] args) {
        m(10);
    }
    public static  void m (int i) {
        System.out.println("start" + i);
        if (i == 0) {
            System.out.println("-----Finish");
            return;}
            m(i - 1);
            System.out.println("finish" + i);
        }

    }