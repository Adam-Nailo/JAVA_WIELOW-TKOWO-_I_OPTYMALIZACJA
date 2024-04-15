package waitandnotify;

public class WaitAndNotifyExample {

    public void waitMethod() throws InterruptedException {
        synchronized (this) {
            System.out.println("Entering the wait method");
            wait();
            System.out.println("Leaving the wait method");
        }
    }

    public void notifyMethod() throws InterruptedException {
        synchronized (this) {
            Thread.sleep(2000);
            notify();
            System.out.println("notify() method triggered");
        }
    }
}
