import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocKetTCP04Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket (9999);
        System.out.println("服务器创建成功，在 9999 端口监听...");
        Socket socket = serverSocket.accept();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println(s);

        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        bw.write("hello, client!");
        bw.newLine();
        bw.flush();

        br.close();
        bw.close();
        socket.close();
        serverSocket.close();



    }
}
