package blockingque;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class CustomerRunnable implements Runnable{

    private List<String> orders = new ArrayList<>();
    private Random random = new Random();
    private BlockingQueue<String> orderQue;

    public CustomerRunnable(BlockingQueue<String> orderQue, String...orders) {
        this.orderQue = orderQue;
        for (String order:orders){
            this.orders.add(order);
        }
    }

    @Override
    public void run() {

        while (true){
            try {
                String pickedOrder =  orders.get(random.nextInt(orders.size()));
                System.out.println("Customer asks for: " + pickedOrder);
                orderQue.put(pickedOrder);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
