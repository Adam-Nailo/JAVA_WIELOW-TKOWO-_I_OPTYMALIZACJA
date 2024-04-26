import blockingque.CustomerRunnable;
import blockingque.RestaurantRunnable;
import cyclicbarrier.CyclicBarrierRunnable;
import delayqueue.DelayedMission;
import priorityblockingqueue.Case;
import priorityblockingqueue.CaseRunnable;
import priorityblockingqueue.HospitalRunnable;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        CyclicBarrier barrier = new CyclicBarrier(3, ()-> System.out.println("Knight is ready"));

        service.execute(new CyclicBarrierRunnable("preparing armor","bringing armor",5000,barrier));
        service.execute(new CyclicBarrierRunnable("preparing horse","bringing horse",7000,barrier));
        service.execute(new CyclicBarrierRunnable("preparing sword","bringing sword",9000,barrier));
    }
}