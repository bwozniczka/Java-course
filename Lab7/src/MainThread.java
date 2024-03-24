class MySecondThread extends Thread{
    public void run(){
        System.out.println("Start wątku dodatkowego");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Zakończenie wątku dodatkowego");
    }
}


public class MainThread {
    public static void main(String[] args){
        System.out.println("Start wątku głównego");
        MySecondThread mySecondThread = new MySecondThread();
        mySecondThread.start();
        try {
            mySecondThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Zakończenie wątku głównego");
    }
}
