import executorservice.ExecutorServiceTask;
import incrementingvolatileproblem.IncrementingRunnable;
import incrementingvolatileproblem.ReadingRunnable;
import incrementingvolatileproblem.SharedCounter;
import locksexample.LockExample;
import semaphore.Dungeon;
import synchronizedproblem.SynchronizedCounter;
import synchronizedproblem.SynchronizedRunnable;
import waitandnotify.WaitAndNotifyExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Dungeon dungeon = new Dungeon(3);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            executorService.submit(() -> dungeon.tryToEnter());
        }

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