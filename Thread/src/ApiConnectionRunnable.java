public class ApiConnectionRunnable implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Closing Thread with ApiConnectionRunnable");
        }
    }
}
