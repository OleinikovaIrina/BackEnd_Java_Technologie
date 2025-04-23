import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.random;

public class Main {
    private static final int N_THREAD = 3;

    public static void main(String[] args) {
//        Компания разрабатывает систему мониторинга производительности веб-сервисов.
//        Один из важных показателей — минимальная задержка ответа (latency) от сервера.
//        Нужно реализовать компонент LatencyMonitor, который отслеживает самое минимальное время отклика,
//        полученное из множества параллельных потоков, поступающих от разных серверов/кластеров.
//        Задержка - случайное целое число (мс), в диапазоне от 0 до Integer.MAX_VALUE.
//        Каждый из N потоков-серверов генерирует это число и вызывает метод updateLatency(double latency)
//        класса LatencyMonitor. Реализация не должна использовать synchronized или блокировки
//        — только атомарные структуры (Atomic*).
        LatencyMonitor monitor = new LatencyMonitor();
        Thread[] threads = new Thread[N_THREAD];
        for (int i = 0; i < N_THREAD; i++) {
            threads[i] = new Thread(() -> {
//                double latency =  Math.random() * Integer.MAX_VALUE;
                int latency = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
                System.out.println("Поток " + Thread.currentThread().getId() +
                        " сгенерировал задержку: " + latency + " мс");
                monitor.updateLatency(latency);
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Минимальная задержка: " + monitor.getMinLatency() + " мс");
    }
}

