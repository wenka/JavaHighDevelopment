package com.wenka;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/08/30  下午 02:29
 * Description: nio 客户端
 */
public class NioClient {

    public void start() throws IOException {
        // 连接服务器端
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8000));

        // 接收服务器端响应
        //新开线程 专门接收服务器端的响应
        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        new Thread(new NioClientHandle(selector)).start();

        // 向服务器端发送数据
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String requst = scanner.nextLine();
            if (requst != null && requst.trim().length() > 0) {
                socketChannel.write(Charset.forName("UTF-8").encode(requst));
            }
        }
    }


    public static void main(String[] args) throws IOException {
        NioClient nioClient = new NioClient();
        nioClient.start();
    }
}
