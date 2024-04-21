package blockingque;

import java.util.concurrent.BlockingQueue;

public class RestaurantRunnable implements Runnable{

    private BlockingQueue<String> orderQue;

    public RestaurantRunnable(BlockingQueue<String> orderQue) {
        this.orderQue = orderQue;
    }

    @Override
    public void run() {

        while (true){
            try {
                String orderToGive = orderQue.take();
                System.out.println("Giving order "+ orderToGive);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
