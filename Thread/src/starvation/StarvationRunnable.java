package starvation;

public class StarvationRunnable {

    private CommonResource commonResource;

    public StarvationRunnable(CommonResource commonResource) {
        this.commonResource = commonResource;
    }
}
