package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class SellRunnable implements Runnable{

    private CountDownLatch countDownLatch;

    public SellRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        sell();
        countDownLatch.countDown();
    }
    private void sell(){
        System.out.println("Character from the thread"+Thread.currentThread().getName()+" is selling items");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Character from the thread"+Thread.currentThread().getName()+" sold items");
    }
}
