package locksexample;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    private int counter;

    private Lock lock = new ReentrantLock();

    public void incrementCounter() {
        lock.lock();
        try {
            for (int i = 0; i < 100000; i++) {
                counter++;
            }
        } finally {
            lock.unlock();
        }
    }


    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
