import blockingque.CustomerRunnable;
import blockingque.RestaurantRunnable;
import delayqueue.DelayedMission;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        BlockingQueue<DelayedMission> missionQueue = new DelayQueue<>();

        try {
            missionQueue.put(new DelayedMission("Character woke up",5000));
            missionQueue.put(new DelayedMission("Character came back from hunt",9000));
            missionQueue.put(new DelayedMission("Character sold items",7000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while (!missionQueue.isEmpty()){
            try {
                DelayedMission take = missionQueue.take();
                System.out.println(take.getMission());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Team is ready for the quest");

    }
}