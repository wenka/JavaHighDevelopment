package com.wenka;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/08/30  下午 02:36
 * Description: 客户端专门接收消息线程
 */
public class NioClientHandle implements Runnable {

    private Selector selector;

    public NioClientHandle(Selector selector) {
        this.selector = selector;
    }

    /**
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println("接收线程已启动");
        try {
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
                        if (selectionKey.isReadable()) { //可读事件
                            this.readHandler(selectionKey, selector);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

        // 循环读取服务器端的请求信息
        String response = "";
        while (socketChannel.read(byteBuffer) > 0) {
            // 切换 buffer 为读模式
            byteBuffer.flip();
            //读取 buffer 中的内容
            response += Charset.forName("UTF-8").decode(byteBuffer);
        }

        // 将 channel 注册到 selector 上， 监听可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);
        // 将服务器发送的请求信息，广播给其他客户端
        System.out.println(">>> " + response);
    }

}
