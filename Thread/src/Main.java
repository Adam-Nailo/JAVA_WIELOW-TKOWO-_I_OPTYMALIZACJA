public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> secondThread());
        thread.setName("Second loop thread");
        thread.start();
        long start = System.currentTimeMillis();
        mainThread();
        long end = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (end - start));
        Thread thread1 = new Thread(() -> System.out.println("Starting another thread: " + Thread.currentThread().getName()));
        thread1.setName("No loop thread");
        thread1.start();
    }

    private static void mainThread() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Starting loop in thread: " + Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.out.println("main thread loop: " + i);
        }
    }

    private static void secondThread() {
        System.out.println("Starting loop in thread: " + Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.out.println("second thread loop: " + i);
        }
    }
}