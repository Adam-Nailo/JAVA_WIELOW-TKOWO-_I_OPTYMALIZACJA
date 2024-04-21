import blockingque.CustomerRunnable;
import blockingque.RestaurantRunnable;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);

        BlockingQueue<String> orderQueue = new ArrayBlockingQueue<>(10);

        service.execute(new CustomerRunnable(orderQueue,"Chicken","Pasta","Beef"));
        service.execute(new CustomerRunnable(orderQueue,"Lamb","Soup","Dumplings"));
        service.execute(new RestaurantRunnable(orderQueue));

    }
}