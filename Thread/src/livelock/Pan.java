package livelock;

public class Pan {

    private Chef owner;

    public Pan(Chef owner) {
        this.owner = owner;
    }

    public Chef getOwner() {
        return owner;
    }

    public void setOwner(Chef owner) {
        this.owner = owner;
    }
}
