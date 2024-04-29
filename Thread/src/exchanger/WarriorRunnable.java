package exchanger;

import java.util.concurrent.Exchanger;

public class WarriorRunnable implements Runnable {
    private Exchanger<Item> exchanger;
    private Item armor;

    public WarriorRunnable(Exchanger<Item> exchanger, Item armor) {
        this.exchanger = exchanger;
        this.armor = armor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Warrior has " + armor);
                Item exchangedItem = exchanger.exchange(armor);
                System.out.println("Warrior recived given item: "+ exchangedItem);
                armor = exchangedItem;
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
