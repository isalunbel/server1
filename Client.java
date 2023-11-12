import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Client {
    public static void main(String args[]) throws IOException {
        String host = "localhost";
        int port = 8080;
        
        try (Socket socket = new Socket(host, port)) {

            try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                out.println("John");

                String response = in.readLine();
                System.out.println("Получен ответ от сервера: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

