package com.johndoeo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class Server {

    public static void main(String[] args) throws InterruptedException {
        //1.第一个线程组是用于接收Client端连接的
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //2.第二个线程组是用于实际的业务处理的
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup);//绑定两个线程池
        b.channel(NioServerSocketChannel.class);//指定NIO的模式，如果是客户端就是NioSocketChannel
        b.option(ChannelOption.SO_BACKLOG, 1024);//TCP的缓冲区设置
        b.option(ChannelOption.SO_SNDBUF, 32*1024);//设置发送缓冲的大小
        b.option(ChannelOption.SO_RCVBUF, 32*1024);//设置接收缓冲区大小
        b.option(ChannelOption.SO_KEEPALIVE, true);//保持连续
        b.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel sc) throws Exception {
                ByteBuf buf = Unpooled.copiedBuffer("$_".getBytes());//拆包粘包定义结束字符串（第一种解决方案）
                sc.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,buf));//在管道中加入结束字符串
                // sc.pipeline().addLast(new FixedLengthFrameDecoder(200));第二种定长
                sc.pipeline().addLast(new StringDecoder());//定义接收类型为字符串把ByteBuf转成String
                sc.pipeline().addLast(new ServerHandler());//在这里配置具体数据接收方法的处理
            }
        });
        ChannelFuture future = b.bind(8765).sync();//绑定端口
        future.channel().closeFuture().sync();//等待关闭(程序阻塞在这里等待客户端请求)
        bossGroup.shutdownGracefully();//关闭线程
        workerGroup.shutdownGracefully();//关闭线程
        new Integer(2);
    }
}
