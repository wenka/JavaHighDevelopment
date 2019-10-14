package demo1.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.Date;

/**
 * Created with IDEA
 * author:wenka wkwenka@gmail.com
 * Date:2019/09/18  下午 03:39
 * Description: 服务器 handler： 需要实现 ChannelInboundHandler  接口。
 * 此处业务简单，使用其子类 ChannelInboundHandlerAdapter 。
 */
@ChannelHandler.Sharable // 标识这个类的实例可以在 channel 里面共享。
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 每个信息入站都会调用
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println((new Date()) + " > server received：" + byteBuf.toString(CharsetUtil.UTF_8));
        ctx.write(Unpooled.copiedBuffer("copy that!", CharsetUtil.UTF_8)); // 将所接收的消息返回给发送者。注意，这还没有冲刷数据
    }

    /**
     * 通知处理器最后的 channelRead() 是当前批处理中的最后一条信息时调用。
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        super.channelReadComplete(ctx);
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER); // 冲刷所有待审消息到远程节点。关闭通道后，操作完成
    }

    /**
     * 读操作捕获到异常时调用
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close(); // 关闭通道
    }
}
