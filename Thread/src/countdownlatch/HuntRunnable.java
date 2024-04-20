package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class HuntRunnable implements Runnable{

    private CountDownLatch countDownLatch;

    public HuntRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        hunt();
        countDownLatch.countDown();
    }
    private void hunt(){
        System.out.println("Character from the thread"+Thread.currentThread().getName()+" is hunting");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Character from the thread"+Thread.currentThread().getName()+" comes back from the hunt");
    }
}
