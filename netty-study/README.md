# 名词定义

1. Channel:
 
 > Channel 是 NIO 基本的结构。它代表了一个用于连接到实体如硬件设备、文件、网络套接字或程序组件，能够执行一个或多个不同的 I/O 操作(例如读和写)的开放连接。
 
 > 亦或称为一个“打开”或“关闭”，“连接”或“断开”和作为传入和传出数据的运输工具。
 
 2. Callback（回调）
 
 > 是一个简单的方法，提供给另一种方法作为引用，这样后者就可以在某个合适的时间调用前者。
 
 > Netty 内部使用回调处理事件时，事件可以由接口 ChannelHandler 的实现来处理。
 
 3. Future
 
 > Future 提供了另外一种通知应用操作已经完成的方式。这个对象作为一个异步操作结果的占位符，它将将来的某个时候按成并提供结果。
 
 > Netty 提供了自己的实现 ChannelFutureListener ，用于执行异步操作时使用。
 
 ---
 Netty 的异步编程模型是建立在 Future 和 Callback 的概念上。拦截操作和转换入站或出站数据只需要提供回调或利用 future 操作返回。一个 Netty 的设计目的是促进“关注点”分离：你的业务逻辑从网络基础设施应用程序中分离。
 
 Netty 通过触发事件从应用程序中抽象出 Selector ，从而避免手写调度代码。EventLoop 分配给每个 Channel 来处理所有的事件：（注册感兴趣的事件、调度事件到ChannelHandler、安排进一步行动）

# Netty 基本构建模块
1. BootStrap
> Netty 应用程序通过设置 bootstrap (引导) 累的开始，该类提供了一个用于应用程序网络层配置的容器。

2. Channel
> 底层网络传输 API 必须提供给应用 I/O 操作的窗口，如读、写、连接、绑定等，类似一个“socket”。
netty 中的接口 Channel 定义了与 socket 丰富交互的操作集： bind\close\config\connect\isActive\isOpen\isWritable\read\write等。
Netty 提供大量的 Channel 实现来专门使用，如：AbstractChannel，AbstractNioByteChannel，AbstractNioChannel，EmbeddedChannel， LocalServerChannel，NioSocketChannel 等。

3. ChannelHandler
> ChannelHandler 支持很多协议，并且提供用于数据处理的容器。ChannelHandler 由特定的事件触发。
> 常用的接口 ChannelInboundHandler，这个类型接收到入站事件(包括接收到的数据)可以处理应用程序逻辑。当你需要提供响应时，你也可以从 ChannelInboundHandler 冲刷数据。业务逻辑经常存活一个或者多个ChannelInboundHandler。

4. ChannelPipeline
> ChannelPipeline 提供了一个容器给 ChannelHandler 链并提供了一个 API 用于管理沿着链入站和出站事件的流动。每个 Channel 都有自己的 ChannelPipeline，当 Channel 创建时自动创建。

> ChannelHandler 是如何添加到 ChannelPipeline 中？主要实现了 ChannelHandler 的抽象 ChannelInitializer。ChannelInitializer通过 ServerBootstrap 进行注册。
当它的 initChannel() 被调用时，这个对象将安装自定义的 ChannelHandler 集到 pipeline。当这个操作完成时，ChannelInitializer子类则从 ChannelPipeline 自动删除自身。
----
若数据是从用户应用程序到远程主机则是“出站(outbound)”，相反若数据时从远程主机到用户应用程序则是“入站(inbound)”。
5. EventLoop
> EventLoop 用于处理 Channel 的 I/O 操作。一个单一的 EventLoop 通常处理多个 Channel 事件。一个 EventLoopGroup 可以含有多余一个的 EventLoop 和提供了一种迭代用于检索清单中的下一个。

6. ChannelFuture
> Netty 所有操作都是异步的。因为一个操作可能无法立即返回，我们需要一种方法在以后确定它的结果。它的 addListener 方法注册了一个 ChannelFutureListener ，当操作完成时，可以被通知。