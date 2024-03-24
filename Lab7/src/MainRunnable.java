class MyFirstThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Start wątku dodatkowego");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Zakończenie wątku dodatkowego");
    }
}

public class MainRunnable {
    public static void main(String[] args){
        System.out.println("Start wątku głównego");

        MyFirstThread myFirstThread = new MyFirstThread();
        Thread thread = new Thread(myFirstThread);

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Zakończenie wątku głównego");
    }
}
