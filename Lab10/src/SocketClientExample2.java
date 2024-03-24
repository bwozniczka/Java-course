import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientExample2 {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
        //get the localhost IP address, if server is running on some other IP, you need to use that
        for (int i = 0; i < 2; i++) {
            new Thread(new MyRunnable(i + 1)).start();
        }
    }
    static class MyRunnable implements Runnable {
        int num;
        MyRunnable(int num) {
            this.num = num;
        }
        @Override
        public void run() {
            try {
                connectClient();
            } catch (IOException | ClassNotFoundException | InterruptedException e) {
            }
        }
        public void connectClient() throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
            InetAddress host = InetAddress.getLocalHost();
            Socket socket = null;
            ObjectOutputStream oos = null;
            ObjectInputStream ois = null;
            while (true) {
                socket = new Socket(host.getHostName(), 9876);
                //write to socket using ObjectOutputStream
                oos = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("Client " + num + " is sending request to Socket Server");
                oos.writeObject("Thread " + num);
                //read the server response message
                ois = new ObjectInputStream(socket.getInputStream());
                String message = (String) ois.readObject();
                System.out.println("Message: " + message);
                //close resources
                ois.close();
                oos.close();
            }
        }
    }
}