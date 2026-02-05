import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(5005);
            System.out.println("server started to listen the clients");
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //clientSocket.getInputStream() -> gives the message form the client in the form of bytes and InputStreamReader converts it
            // understandable characters
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);

            String clientMessage = in.readLine();
            System.out.println("client says: "+clientMessage);

            out.println("hello from server");

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Server stopped");
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
