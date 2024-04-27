package concurrenthashmap;

import java.util.concurrent.ConcurrentMap;

public class GettingItemsRunnable implements Runnable{

    private ConcurrentMap<Integer, String> map;

    public GettingItemsRunnable(ConcurrentMap<Integer, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
            System.out.println(map.get(1));
            System.out.println(map.get(3));
            Thread.sleep(1000);
            System.out.println(map.get(4));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
