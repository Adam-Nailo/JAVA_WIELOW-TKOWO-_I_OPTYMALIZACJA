import blockingque.CustomerRunnable;
import blockingque.RestaurantRunnable;
import concurrenthashmap.AddingItemsRunnable;
import concurrenthashmap.GettingItemsRunnable;
import cyclicbarrier.CyclicBarrierRunnable;
import delayqueue.DelayedMission;
import exchanger.BlacksmithRunnable;
import exchanger.Item;
import exchanger.WarriorRunnable;
import priorityblockingqueue.Case;
import priorityblockingqueue.CaseRunnable;
import priorityblockingqueue.HospitalRunnable;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Exchanger<Item> itemExchanger = new Exchanger<>();

        service.execute(new WarriorRunnable(itemExchanger, new Item("Basic armor",0)));
        service.execute(new BlacksmithRunnable(itemExchanger, new Item("Reinforced armor",2)));
    }
}