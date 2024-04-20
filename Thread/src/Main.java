import callable.Divider;
import countdownlatch.HuntRunnable;
import countdownlatch.SellRunnable;
import countdownlatch.SleepRunnable;
import executorservice.ExecutorServiceTask;
import incrementingvolatileproblem.IncrementingRunnable;
import incrementingvolatileproblem.ReadingRunnable;
import incrementingvolatileproblem.SharedCounter;
import locksexample.LockExample;
import semaphore.Dungeon;
import synchronizedproblem.SynchronizedCounter;
import synchronizedproblem.SynchronizedRunnable;
import waitandnotify.WaitAndNotifyExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        List<Runnable> tasks = new ArrayList<>();
        tasks.add(new SleepRunnable(countDownLatch));
        tasks.add(new HuntRunnable(countDownLatch));
        tasks.add(new SellRunnable(countDownLatch));

        ExecutorService service = Executors.newFixedThreadPool(3);

        for(Runnable task: tasks){
            service.execute(task);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Team is ready for mission");
    }
}