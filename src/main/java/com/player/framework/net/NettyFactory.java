package com.player.framework.net;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public enum NettyFactory {

    INSTANCE;

    private EventLoopGroup bossGroup = new NioEventLoopGroup(4);
    private EventLoopGroup workerGroup = new NioEventLoopGroup();

    public void initialize(int port) throws Exception {
        try {
            System.out.println("Loading netty service...");
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new NettyHandler());
            b.bind(new InetSocketAddress(port)).sync();
            System.out.println("Loading netty service successfully!");
        } catch (Exception e) {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
            throw e;
        }
    }

    protected static class NettyHandler extends ChannelInitializer<SocketChannel> {
        protected void initChannel(SocketChannel channel) throws Exception {
            ChannelPipeline p = channel.pipeline();
            // TODO: LengthFieldBasedFrameDecoder用来处理断包粘包,必须在自定义解码器前
            //maxFrameLength - 发送的数据帧最大长度
            //lengthFieldOffset - 定义长度域位于发送的字节数组中的下标。换句话说：发送的字节数组中下标为${lengthFieldOffset}的地方是长度域的开始地方
            //lengthFieldLength - 用于描述定义的长度域的长度。换句话说：发送字节数组bytes时, 字节数组bytes[lengthFieldOffset, lengthFieldOffset+lengthFieldLength]域对应于的定义长度域部分
            //lengthAdjustment - 满足公式: 发送的字节数组bytes.length - lengthFieldLength = bytes[lengthFieldOffset, lengthFieldOffset+lengthFieldLength] + lengthFieldOffset + lengthAdjustment
            //initialBytesToStrip - 接收到的发送数据包，去除前initialBytesToStrip位
            //failFast - true: 读取到长度域超过maxFrameLength，就抛出一个 TooLongFrameException。false: 只有真正读取完长度域的值表示的字节之后，才会抛出 TooLongFrameException，默认情况下设置为true，建议不要修改，否则可能会造成内存溢出
            //ByteOrder - 数据存储采用大端模式或小端模式
            p.addLast(new LengthFieldBasedFrameDecoder(
                    2048 * 100,
                    8,//数据长度位置
                    2,//数据长度长度
                    0,
                    0));//省略位数
			p.addLast(new NettyProtocolEncoder());//自定义编码器
			p.addLast(new NettyProtocolDecoder());//自定义解码器
            p.addLast(new NettyChannelHandler(MessageDispatcherFactory.INSTANCE));
        }
    }

}
