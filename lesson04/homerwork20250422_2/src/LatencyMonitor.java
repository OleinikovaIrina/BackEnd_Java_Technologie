import java.util.concurrent.atomic.AtomicInteger;


public class LatencyMonitor {

    private final AtomicInteger minLatency = new AtomicInteger(Integer.MAX_VALUE);



    public void updateLatency(int latency) {
        int currentMin = minLatency.get();
        while (latency < currentMin) {
            if (minLatency.compareAndSet(currentMin, latency)) {
                return;
            }
            currentMin = minLatency.get();
        }
    }

    public int getMinLatency() {
        return minLatency.get();
    }
}

