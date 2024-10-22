import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP04Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("192.168.1.104"),9999);

        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        bw.write("hello,client!");
        bw.newLine();
        bw.flush();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println(s);

        bw.close();
        br.close();
        socket.close();
    }
}
