package com.player.framework.client;

import com.player.framework.net.*;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * netty客户端
 */
public class NettyClient {

    public Channel connect(String hostname, int port, IdSession idSession) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        Channel channel;
        try {
            Bootstrap bootstrap = new Bootstrap();
//            bootstrap.group(group)
//                    .channel(NioSocketChannel.class)
//                    .remoteAddress(new InetSocketAddress(hostname, port))
//                    .handler(new ClientNettyHandler());
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new LengthFieldBasedFrameDecoder(
                                    2048 * 100,
                                    8,//数据长度位置
                                    2,//数据长度长度
                                    0,
                                    0));//省略位数
                            p.addLast(new NettyProtocolEncoder());//自定义编码器
                            p.addLast(new NettyProtocolDecoder());//自定义解码器
                            p.addLast(new NettyClientHandler(MessageDispatcherFactory.INSTANCE, idSession));
                        }
                    });
            channel = bootstrap.connect(hostname, port).sync().channel();
//            channelFuture.channel().closeFuture().sync();
        } finally {
            //group.shutdownGracefully().sync();
        }
        return channel;
    }

}