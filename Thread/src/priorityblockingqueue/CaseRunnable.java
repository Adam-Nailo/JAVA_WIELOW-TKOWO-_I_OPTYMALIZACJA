package priorityblockingqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class CaseRunnable implements Runnable {

    private BlockingQueue<Case> caseQueue;
    private List<Case> cases = new ArrayList<>();
    private Random random = new Random();

    public CaseRunnable(BlockingQueue<Case> caseQueue, Case... cases) {
        this.caseQueue = caseQueue;
        for (Case c : cases) {
            this.cases.add(c);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Case randomCase = cases.get(random.nextInt(cases.size()));
                System.out.println("Case from thread: " + Thread.currentThread().getName() +
                        " arrived, type: " + randomCase.getType() + ", priority: " + randomCase.getPriority());
                caseQueue.put(randomCase);
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
