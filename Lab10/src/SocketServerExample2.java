import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerExample2 {
    private static ServerSocket serverSocket;
    private static int port = 9876;
    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server is running and waiting for clients...");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());
            Thread clientThread = new Thread(new ClientHandler(clientSocket));
            clientThread.start();
        }
    }
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }
        @Override
        public void run() {
            try {
                ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                while (true) {
                    String message = (String) ois.readObject();
                    System.out.println("Message Received from " + message);
                    oos.writeObject("Hi Client " + message);
                    if (message.equalsIgnoreCase("exit")) {
                        System.out.println("Client disconnected: " + clientSocket.getInetAddress());
                        break;
                    }
                }
                ois.close();
                oos.close();
                clientSocket.close();

            } catch (IOException | ClassNotFoundException e) {
            }
        }
    }
}
