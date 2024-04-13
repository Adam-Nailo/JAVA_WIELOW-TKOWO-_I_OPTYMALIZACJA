import incrementingvolatileproblem.IncrementingRunnable;
import incrementingvolatileproblem.ReadingRunnable;
import incrementingvolatileproblem.SharedCounter;

public class Main {
    public static void main(String[] args) {
        SharedCounter counter = new SharedCounter();
        Thread counterThread = new Thread(new IncrementingRunnable(counter));
        Thread readingThread = new Thread(new ReadingRunnable(counter));
        counterThread.start();
        readingThread.start();
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