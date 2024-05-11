package livelock;

public class Chef {
    private String name;
    private boolean isCooking;

    public Chef(String name, boolean isCooking) {
        this.name = name;
        this.isCooking = isCooking;
    }

    public String getName() {
        return name;
    }
    public boolean isCooking(){
        return isCooking;
    }

    public synchronized void work()
}
