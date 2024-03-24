import java.util.Random;

class NThread extends Thread {
    private final int threadNumber;

    public NThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        Random random = new Random();
        int randomTime = random.nextInt(1000);
        System.out.println("Wątek " + threadNumber + " został uruchomiony. Czas uśpienia: " + randomTime + " ms");
        try {
            Thread.sleep(randomTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Wątek " + threadNumber + " zakończył działanie.");
    }
}

public class MainNTimes {
    public static void main(String[] args) {
        int n = 6;

        Thread[] threads = new Thread[n];

        for (int i = 0; i < n; i++) {
            threads[i] = new NThread(i + 1);
            threads[i].start();
        }

        for (int i = 0; i < n; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Główny wątek zakończył działanie po zakończeniu wszystkich wątków dodatkowych.");
    }
}
