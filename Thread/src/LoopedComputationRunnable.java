public class LoopedComputationRunnable implements Runnable{
    @Override
    public void run() {
        int i = 0;
        while (i<2){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Closing Thread running LoopedComputationRunnable");
                return;
            }
            i++;
            i--;
        }
    }
}
