package deadlock;

public class Builder {
    private MineralResource mineralResource = new MineralResource();
    private SteelResource steelResource = new SteelResource();

    public void buildShip() {
        synchronized (mineralResource) {
            mineralResource.getMinerals();
            synchronized (steelResource) {
                steelResource.getSteel();
            }
        }
        System.out.println("Ship has been build in thread: " + Thread.currentThread().getName());
    }

    public void buildFighter() {
        synchronized (mineralResource) {
            mineralResource.getMinerals();
            synchronized (steelResource) {
                steelResource.getSteel();
            }
        }
        System.out.println("Fighter has been build in thread: " + Thread.currentThread().getName());
    }
}
