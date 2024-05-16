package diningphilosophers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

    private long id;
    private Lock lock = new ReentrantLock();

    public Chopstick(long id) {
        this.id = id;
    }

    public boolean pickUp(Philosopher philosopher) throws InterruptedException {
        if(lock.tryLock(15, TimeUnit.MILLISECONDS)){
            System.out.println(philosopher + " picked up "+this);
            return true;
        }
        return false;
    }
    public void putDown(Philosopher philosopher){
        lock.unlock();
        System.out.println(philosopher + " put down "+this);
    }

    @Override
    public String toString() {
        return "Chopstick{" +
                "id=" + id +
                '}';
    }
}
