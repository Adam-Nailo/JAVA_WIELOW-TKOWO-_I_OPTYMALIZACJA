import callable.Divider;
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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

       ExecutorService service = Executors.newFixedThreadPool(5);

        List<Future<Double>> list = new ArrayList<>();

       for (int i =0;i<5;i++){
           Future<Double> result = service.submit(new Divider((double) (i * 5)));
           list.add(result);
       }

       for(Future<Double> result: list){
           try {
               System.out.println(result.get());
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           } catch (ExecutionException e) {
               throw new RuntimeException(e);
           }
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