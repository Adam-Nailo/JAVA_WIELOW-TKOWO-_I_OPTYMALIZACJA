package concurrenthashmap;

import java.util.concurrent.ConcurrentMap;

public class AddingItemsRunnable implements Runnable{

    private ConcurrentMap<Integer, String> map;

    public AddingItemsRunnable(ConcurrentMap<Integer, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            map.put(1,"armor");
            map.put(2,"sword");
            map.put(3,"pickaxe");
            Thread.sleep(1000);
            map.put(4, "apple");
            map.put(5, "shield");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
