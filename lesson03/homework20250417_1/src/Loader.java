public class Loader implements Runnable {

    private String name;
    private int nBox;
    private int capacity;
    private Warehouse warehouse;
    private int done = 0;
    private static String winner;
    private static final Object lock = new Object();

    public Loader(String name, int nBox, int capacity, Warehouse warehouse) {
        this.name = name;
        this.nBox = nBox;
        this.capacity = capacity;
        this.warehouse = warehouse;
    }


    @Override
    public void run() {
        while (done < nBox) {
            int value = Math.min(nBox - done, capacity);
            warehouse.addValue(value);
            done += capacity;

        }


                synchronized (lock) {
                    if (done == nBox) {
                    if (winner == null) {
                        winner = name;
                        System.out.println(name + " receives a bonus");

                    }
                }
            }
            System.out.println(name + " finish. Get: " + done + " boxes");
        }
    }
