import blockingque.CustomerRunnable;
import blockingque.RestaurantRunnable;
import concurrenthashmap.AddingItemsRunnable;
import concurrenthashmap.GettingItemsRunnable;
import cyclicbarrier.CyclicBarrierRunnable;
import delayqueue.DelayedMission;
import priorityblockingqueue.Case;
import priorityblockingqueue.CaseRunnable;
import priorityblockingqueue.HospitalRunnable;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        ConcurrentMap<Integer,String> map = new ConcurrentHashMap<>();

        service.execute(new AddingItemsRunnable(map));
        service.execute(new GettingItemsRunnable(map));
    }
}