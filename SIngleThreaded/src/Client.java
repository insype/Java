import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args)
    {
        try{
            Socket socket = new Socket("localhost",5005);
            System.out.println("connected to the server");

            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Hello form the client");

            String serverResponse = in.readLine();
            System.out.println("Server says :"+serverResponse);

            in.close();
            out.close();
            socket.close();
            System.out.println("Client stopped");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
