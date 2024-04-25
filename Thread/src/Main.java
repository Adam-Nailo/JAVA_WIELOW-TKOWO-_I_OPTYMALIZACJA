import blockingque.CustomerRunnable;
import blockingque.RestaurantRunnable;
import delayqueue.DelayedMission;
import priorityblockingqueue.Case;
import priorityblockingqueue.CaseRunnable;
import priorityblockingqueue.HospitalRunnable;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        BlockingQueue<Case> caseQueue = new PriorityBlockingQueue<>();

        Case case1 = new Case("flu",2);
        Case case2 = new Case("common cold",1);
        Case case3 = new Case("broken finger",3);

        service.execute(new CaseRunnable(caseQueue,case1,case2,case3));

        Case case4 = new Case("flu",2);
        Case case5 = new Case("pneumonia",5);
        Case case6 = new Case("broken leg",4);

        service.execute(new CaseRunnable(caseQueue,case4,case5,case6));

        service.execute(new HospitalRunnable(caseQueue));
    }
}