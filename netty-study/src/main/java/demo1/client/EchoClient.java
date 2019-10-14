package demo1.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/09/18  下午 04:17
 * Description:
 */
public class EchoClient {

    private final String host;

    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws InterruptedException {
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();

        try {
            // 创建 Bootstrap
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(nioEventLoopGroup) // 指定 EventLoopGroup 来处理客户端事件。由于我们使用 NIO 传输，所以用到了 NioEventLoopGroup 的实现
                    .channel(NioSocketChannel.class) // 使用的 channel 类型是一个用于 NIO 传输
                    .remoteAddress(new InetSocketAddress(host, port)) // 设置服务器的 InetSocketAddress
                    .handler(new ChannelInitializer<SocketChannel>() { // 当建立一个连接和一个新的通道时，创建添加到 EchoClientHandler 实例 到 channel pipeline
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoClientHandler());
                        }
                    });

            // 连接到远程;等待连接完成
            ChannelFuture channelFuture = bootstrap.connect().sync();

            //阻塞直到 Channel 关闭
            channelFuture.channel().closeFuture().sync();
        } finally {
            // 调用 shutdownGracefully() 来关闭线程池和释放所有资源
            nioEventLoopGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoClient("127.0.0.1",8081).start();
    }
}
