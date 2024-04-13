package incrementingvolatileproblem;

public class ReadingRunnable implements Runnable {

    private SharedCounter sharedCounter;

    public ReadingRunnable(SharedCounter sharedCounter) {
        this.sharedCounter = sharedCounter;
    }

    @Override
    public void run() {
        System.out.println("ReadingRunnable, value of the counter: " + sharedCounter.counter);
    }
}
