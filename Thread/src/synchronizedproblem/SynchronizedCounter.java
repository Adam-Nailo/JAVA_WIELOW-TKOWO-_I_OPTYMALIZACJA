package synchronizedproblem;

public class SynchronizedCounter {
    private int counter;

    public void increment() {
        synchronized (this) {
            setCounter(getCounter() + 1);
        }
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
