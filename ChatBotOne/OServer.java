import java.io.*;
import java.net.*;

// import io.socket.server.*;

public class OServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3006);
        System.out.println("Server started on port 3006");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new ClientHandler(clientSocket).start();
        }
    }
}

class ClientHandler extends Thread {
    Socket clientSocket;

    ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            output.println("Server is Live...");

            String input;
            while ((input = in.readLine()) != null) {
                if(input.equals("hi")|| input.equals("Hi")||input.equals("hello")||input.equals("Hello")){
                    output.println("Server: Namaste");
                }
                else if(input.equals("how are you")|| input.equals("How are you")){
                    output.println("Server: I'm Good");
                }
                ;
            }

            in.close();
            output.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + clientSocket.getPort() + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}

