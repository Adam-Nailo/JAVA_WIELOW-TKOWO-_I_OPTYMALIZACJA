import incrementingvolatileproblem.IncrementingRunnable;
import incrementingvolatileproblem.ReadingRunnable;
import incrementingvolatileproblem.SharedCounter;
import locksexample.LockExample;
import synchronizedproblem.SynchronizedCounter;
import synchronizedproblem.SynchronizedRunnable;
import waitandnotify.WaitAndNotifyExample;

public class Main {
    public static void main(String[] args) {

        LockExample lockExample = new LockExample();

        Thread thread1 = new Thread(()->lockExample.incrementCounter());
        Thread thread2 = new Thread(()->lockExample.incrementCounter());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter result: " + lockExample.getCounter());
    }


    private static void mainThread() {
        System.out.println("Starting loop in thread: " + Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.out.println("main thread loop: " + i);
        }
    }

    private static void secondThread() {
        System.out.println("Starting loop in thread: " + Thread.currentThread().getName());
        throw new RuntimeException("Some exception");
//        for (int i = 0; i < 100; i++) {
//            System.out.println("second thread loop: " + i);
//        }
    }
}