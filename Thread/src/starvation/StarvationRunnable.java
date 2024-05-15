package starvation;

public class StarvationRunnable implements Runnable{

    private CommonResource commonResource;

    public StarvationRunnable(CommonResource commonResource) {
        this.commonResource = commonResource;
    }

    @Override
    public void run() {
        commonResource.getResource();
    }
}
