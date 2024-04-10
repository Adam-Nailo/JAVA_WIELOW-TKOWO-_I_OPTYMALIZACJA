public class Main {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new CustomRunnable());
        thread1.start();

        Thread thread2 = new CustomThread();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Job is done.");
    }

//        Thread thread = new Thread(() -> secondThread());
//        thread.setName("Second loop thread");
//        thread.setPriority(Thread.MAX_PRIORITY);
//        System.out.println("Second thread priority: " + thread.getPriority());
//        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                System.out.println("Thread: " + t.getName() + ", unhandled exception thrown: " + e.getMessage());
//            }
//        });
//        thread.start();
//        mainThread();
//        Thread thread1 = new Thread(() -> System.out.println("Starting another thread: " + Thread.currentThread().getName()));
//        System.out.println("Main thread priority: " + Thread.currentThread().getPriority());
//        thread1.setName("No loop thread");
//        thread1.start();
//    }

    private static void mainThread() {
        System.out.println("Starting loop in thread: " + Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            System.out.println("main thread loop: " + i);
        }
    }

    private static void secondThread() {
        System.out.println("Starting loop in thread: " + Thread.currentThread().getName());
        throw new RuntimeException("Some exception");
//        for (int i = 0; i < 100; i++) {
//            System.out.println("second thread loop: " + i);
//        }
    }
}