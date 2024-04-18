package semaphore;

import java.util.concurrent.Semaphore;

public class Dungeon {

    private Semaphore semaphore;

    public Dungeon(int limitOfPlayers) {
        semaphore = new Semaphore(limitOfPlayers);
    }

    public void tryToEnter() {
        try {
            semaphore.acquire();
            System.out.println("Player from the thread: " + Thread.currentThread().getName() + " enters dungeon");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Player from the thread: " + Thread.currentThread().getName() + " leaves dungeon");
            semaphore.release();
        }
    }
}
