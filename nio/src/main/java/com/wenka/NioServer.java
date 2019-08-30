package com.wenka;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/08/30  下午 02:00
 * Description: NIO 服务器端
 */
public class NioServer {

    public void start() throws IOException {
        // 1. 创建 Selector
        Selector selector = Selector.open();

        // 2. 通过 ServerSockerChannel 创建 channel 通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 3. 为 channel 通道绑定监听端口
        serverSocketChannel.bind(new InetSocketAddress(8000));

        // 4. 设置 channel 为非阻塞模式
        serverSocketChannel.configureBlocking(false);

        // 5. 将 channel 注册到 selector 上，监听连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("服务器启动成功！");

        // 6. 循环等待新接入的连接
        while (true) {
            // 获取可用的 channel 数量 todo
            int readyChannels = selector.select();
            if (readyChannels > 0) {
                // 获取可用 channel 的集合
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey selectionKey = keyIterator.next();
                    keyIterator.remove();

                    // 7. 根据就绪状态，调用对应方法处理业务逻辑
                    if (selectionKey.isAcceptable()) { //接入事件
                        this.acceptHandler(serverSocketChannel, selector);
                    }

                    if (selectionKey.isReadable()) { //可读事件
                        this.readHandler(selectionKey, selector);
                    }
                }
            }
        }
    }

    /**
     * 接入事件处理器
     */
    private void acceptHandler(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
        // 创建 socketChannel
        SocketChannel socketChannel = serverSocketChannel.accept();

        // 将 socketChannel 设置为非阻塞工作模式
        socketChannel.configureBlocking(false);

        // 将 channel 注册到 selector 上， 监听可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);

        // 回复客户端提示信息
        socketChannel.write(Charset.forName("UTF-8").encode("你与成功连接服务器！"));
    }

    /**
     * 可读事件处理器
     */
    private void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {
        // 从 selectionKey 中 获取到已就绪的 channel
        SelectableChannel channel = selectionKey.channel();
        SocketChannel socketChannel = (SocketChannel) channel;

        // 创建 buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 循环读取客户端的请求信息
        String requst = "";
        while (socketChannel.read(byteBuffer) > 0) {
            // 切换 buffer 为读模式
            byteBuffer.flip();

            //读取 buffer 中的内容
            requst += Charset.forName("UTF-8").decode(byteBuffer);
        }

        // 将 channel 注册到 selector 上， 监听可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);

        // 将客户端发送的请求信息，广播给其他客户端
        if (requst.length() > 0) {
            System.out.println(">>> " + requst);
            this.broadCast(selector, socketChannel, requst);
        }

    }

    /**
     * 广播给其他客户端
     */
    private void broadCast(Selector selector, SocketChannel socketChannel, String request) throws IOException {
        // 获取所有已接入的客户端 channel
        for (SelectionKey selectionKey : selector.keys()) {
            SelectableChannel targetChannel = selectionKey.channel();
            if (targetChannel instanceof SocketChannel && targetChannel != socketChannel) { //不是当前channel
                ((SocketChannel) targetChannel).write(Charset.forName("UTF-8").encode(request));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new NioServer().start();
    }
}
