import incrementingvolatileproblem.IncrementingRunnable;
import incrementingvolatileproblem.ReadingRunnable;
import incrementingvolatileproblem.SharedCounter;
import synchronizedproblem.SynchronizedCounter;
import synchronizedproblem.SynchronizedRunnable;

public class Main {
    public static void main(String[] args) {
        SynchronizedCounter counter = new SynchronizedCounter();

        Thread thread1 = new Thread(new SynchronizedRunnable(counter));
        Thread thread2 = new Thread(new SynchronizedRunnable(counter));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Result of counter incrementation: " + counter.getCounter());

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