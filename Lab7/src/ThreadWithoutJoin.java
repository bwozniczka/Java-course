import java.util.Random;

class Threadd extends Thread {
    private static int counter = 0;
    private final int threadNumber;

    public Threadd(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        try {
            synchronized (Threadd.class) {
                counter++;
            }
            int randomTime = new Random().nextInt(1001);
            System.out.println("Wątek " + threadNumber + " uruchomiony. Czas uśpienia: " + randomTime + " ms");
            sleep(randomTime);
            System.out.println("Wątek " + threadNumber + " zakończył działanie.");

            synchronized (Threadd.class) {
                counter--;

                if (counter == 0) {
                    Threadd.class.notifyAll();
                }
            }

        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public static synchronized void waitForThreadsToFinish() {
        while (counter > 0) {
            try {
                Threadd.class.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }
}

public class ThreadWithoutJoin {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Wątek główny rozpoczęty");
        Threadd[] threads = new Threadd[n];

        for (int i = 0; i < n; i++) {
            threads[i] = new Threadd(i + 1);
            threads[i].start();
        }

        Threadd.waitForThreadsToFinish();

        System.out.println("Główny wątek zakończył działanie po zakończeniu wszystkich wątków.");
    }
}
