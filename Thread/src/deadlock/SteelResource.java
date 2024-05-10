package deadlock;

public class SteelResource {
    public void getSteel(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Getting steel for thread: "+Thread.currentThread().getName());
    }
}
