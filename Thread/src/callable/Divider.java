package callable;

import java.util.concurrent.Callable;

public class Divider implements Callable<Double> {

    private Double number;

    public Divider(Double number) {
        this.number = number;
    }

    @Override
    public Double call() throws Exception {
        System.out.println("Entering call method, thread " + Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println("Leaving call method, thread " + Thread.currentThread().getName());
        return number / 2;
    }
}
