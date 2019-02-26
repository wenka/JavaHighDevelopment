package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/01/30  下午 02:12
 * Description:
 */
public class Server {

    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String temp = null;
        String info = "";
        while ((temp = bufferedReader.readLine()) != null) {
            info += temp;
            System.out.println("已接收到客户端连接");
            System.out.println("服务端接收到客户端信息：" + info + ",当前客户端ip为：" + socket.getInetAddress().getHostAddress());
        }

        OutputStream outputStream = socket.getOutputStream();//获取一个输出流，向服务端发送信息
        PrintWriter printWriter = new PrintWriter(outputStream);//将输出流包装成打印流
        printWriter.print("你好，服务端已接收到您的信息");
        printWriter.flush();
        socket.shutdownOutput();//关闭输出流


        //关闭相对应的资源
        printWriter.close();
        outputStream.close();
        bufferedReader.close();
        inputStream.close();
        socket.close();
    }
}
