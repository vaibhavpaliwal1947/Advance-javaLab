
import java.io.*;
import java.net.*;

public class server {

    public static void main(String[] args) {

        try {
            // Create server socket on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Server started...");
            System.out.println("Waiting for client...");

            // Wait for client connection
            Socket socket = serverSocket.accept();

            System.out.println("Client connected.");

            // Read data from client
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            // Send data to client
            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true
            );

            // Receive message
            String message = input.readLine();

            System.out.println("Client says: " + message);

            // Send response
            output.println("Hello Client");

            // Close connections
            socket.close();
            serverSocket.close();

            System.out.println("Connection closed.");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}