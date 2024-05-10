package deadlock;

public class MainDeadlock {
    public static void main(String[] args) {
        Builder builder = new Builder();

        Thread thread1 = new Thread(() -> {
            builder.buildShip();
        });
        Thread thread2 = new Thread(() -> {
            builder.buildFighter();
        });
        thread1.start();
        thread2.start();
    }
}
