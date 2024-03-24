import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class SocketServerExample3 {
    private static ServerSocket server;
    private static int port = 9876;

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        server = new ServerSocket(port);

        while (true) {
            System.out.println("Waiting for the client request");
            Socket socket = server.accept();
            // Handle client communication in a separate thread
            new Thread(new ClientHandler(socket)).start();
        }
    }
    static class ClientHandler implements Runnable {
        private Socket socket;
        public ClientHandler(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            handleClient();
        }
        private void handleClient() {
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                while (true) {
                    try {
                        String message = (String) ois.readObject();
                        Random generator = new Random();
                        System.out.println("Message Received from Client: " + message);
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject("Losowa liczba od serwera: " + generator.nextInt()*3);
                    } catch (EOFException e) {
                        // Client disconnected, close resources and exit the loop
                        System.out.println("Client disconnected");
                        break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
