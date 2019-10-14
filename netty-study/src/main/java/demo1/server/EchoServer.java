package demo1.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/09/18  下午 03:59
 * Description:
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoServer(8081).start();
    }

    public void start() throws InterruptedException {
        // 创建 EventLoopGroup
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        try {
            // 创建 ServerBootstrap
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(nioEventLoopGroup)
                    .channel(NioServerSocketChannel.class) // 指定使用 NIO 的传输 Channel
                    .localAddress(new InetSocketAddress(port)) // 设置 socket 地址使用所选的端口
                    /**
                     * 当一个新的连接被接受，一个新的子 Channel 将被创建
                     * ChannelInitializer 会添加 EchoServerHandler 的实例到 Channel 的 ChannelPipeline 上
                     */
                    .childHandler(new ChannelInitializer<SocketChannel>() { // 添加 EchoServerHandler 到 Channel 的 ChannelPipeline
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoServerHandler());
                        }
                    });

            // 绑定的服务器;sync 等待服务器关闭
            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            System.out.println(EchoServer.class.getName() + " started and listen on " + channelFuture.channel().localAddress());

            // 关闭 channel 和 块，直到服务器 Channel 被关闭
            channelFuture.channel().closeFuture().sync();
        } finally {
            // 关闭 EventLoopGroup，释放所有资源
            nioEventLoopGroup.shutdownGracefully().sync();
        }

    }
}
