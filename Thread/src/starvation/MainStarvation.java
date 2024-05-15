package starvation;

import java.util.Random;

public class MainStarvation {

    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        Thread t1 = new Thread(new StarvationRunnable(commonResource), "max priority thread");
        Thread t2 = new Thread(new StarvationRunnable(commonResource), "thread with priority 2");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(2);

        Random random = new Random();

        t1.start();
        t2.start();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new StarvationRunnable(commonResource), "thread" + i);
            thread.setPriority(random.nextInt(10) + 1);
            thread.start();
        }
    }
}
