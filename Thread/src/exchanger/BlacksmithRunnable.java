package exchanger;

import java.util.concurrent.Exchanger;

public class BlacksmithRunnable implements Runnable {
    private Exchanger<Item> exchanger;
    private Item armor;

    public BlacksmithRunnable(Exchanger<Item> exchanger, Item armor) {
        this.exchanger = exchanger;
        this.armor = armor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Blacksmith has " + armor);
                Item exchangedItem = exchanger.exchange(armor);
                System.out.println("Blacksmith recived given item: " + exchangedItem);
                exchangedItem.setModifier(exchangedItem.getModifier() + 2);
                armor = exchangedItem;
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
