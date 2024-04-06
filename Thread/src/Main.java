public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("second thread loop: " + i);
            }
        });

        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main thread loop: " + i);
        }

    }
}