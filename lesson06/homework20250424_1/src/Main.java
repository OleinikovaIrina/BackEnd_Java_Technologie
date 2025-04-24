import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Account accountA = new Account("DE1111", "Jack", 1000);
        Account accountB = new Account("DE2222", "John", 1000);

        Thread thread1 = new Thread(() -> transfer(accountA, accountB, 100), "T1");
        Thread thread2 = new Thread(() -> transfer(accountB, accountA, 500), "T2");
        Thread lockMonitor = new DeadlockDetector();


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(accountA);
        System.out.println(accountB);

    }

    public static void transfer(Account from, Account to, double amount)  {
        Account first = from.hashCode() < to.hashCode() ? from : to;
        Account second = from.hashCode() < to.hashCode() ? to : from;


        try {
            if (first.getLock().tryLock(1, TimeUnit.SECONDS)) {
                try {
                    if (second.getLock().tryLock(1, TimeUnit.SECONDS)) {
                        try {
                            System.out.println("account " + from + " is locked by " + Thread.currentThread().getName());
                            System.out.println("account " + to + " is locked by " + Thread.currentThread().getName());

                            if (from.withdraw(amount)) {
                                to.deposit(amount);
                            }
                            System.out.println("transfer is finish");
                        } finally {
                            second.getLock().unlock();
                            System.out.println("account " + to + " is unlocked");
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + ": не смог захватить второй замок");
                    }
                } finally {
                    first.getLock().unlock();
                    System.out.println("account " + from + " is unlocked");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ": не смог захватить первый замок");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ": прерван при ожидании блокировки");
        }
    }
}