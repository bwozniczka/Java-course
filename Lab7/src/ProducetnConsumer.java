import java.util.ArrayList;
import java.util.Random;

class ProducerConsumer {

    private static final int NUM_PRODUCERS = 10;
    private static final int NUM_CONSUMERS = 3;
    private static final ArrayList<String> sharedBuffer = new ArrayList<>();
    private static int totalCount = 0;

    public static void main(String[] args) {

        for (int i = 0; i < NUM_PRODUCERS; i++) {
            new Thread(new Producer(i)).start();
        }

        for (int i = 0; i < NUM_CONSUMERS; i++) {
            new Thread(new Consumer(i)).start();
        }

        try {
            Random random = new Random();
            int randomTime = random.nextInt(10000);
            Thread.sleep(randomTime);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        System.exit(0);
    }
    static class Producer implements Runnable {
        private final int id;
        Producer(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Random random = new Random();
                    int randomTime = random.nextInt(1000);
                    Thread.sleep(randomTime);
                    produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        }
        private void produce() throws InterruptedException {
            synchronized(this) {
                String data = "Producent " + id + ", " + (++totalCount);
                sharedBuffer.add(data);
                System.out.println("Wyprodukowano " + data + ", rozmiar obiektu " + sharedBuffer.size());
            }
        }
    }

    static class Consumer implements Runnable {
        private final int id;

        Consumer(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(new Random().nextInt(1000));
                    consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        }
        private void consume() throws InterruptedException {
            synchronized (this) {
                if (!sharedBuffer.isEmpty()) {
                    String data = sharedBuffer.remove(0);
                    System.out.println("Pobrano " + data + " przez konsumenta " + id + ", rozmiar obiektu " + sharedBuffer.size());
                }
                else {
                    System.out.println("Nie ma produktow ");
                }
            }
        }
    }
}
