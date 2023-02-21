package com.player.framework.net;


import com.player.framework.serializer.Message;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public class NettyChannelHandler extends ChannelInboundHandlerAdapter {

    private MessageDispatcherFactory messageDispatcher;

    public NettyChannelHandler(MessageDispatcherFactory messageDispatcher) {
        super();
        this.messageDispatcher = messageDispatcher;
    }

    /**
     * 进入连接
     * @param ctx
     * @throws Exception
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        IdSession session = new PlayerSession(channel);
        SessionManager.add2Anonymous(session);
        this.messageDispatcher.onSessionCreated(session);
    }
    /**
     * 接收消息
     * @param ctx
     * @param msg
     * @throws Exception
     */
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        IdSession session = SessionManager.getSessionBy(ctx.channel());
        this.messageDispatcher.dispatch(session, (Message) msg);

    }
    /**
     * 断开连接
     * @param ctx
     * @throws Exception
     */
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        IdSession session = SessionManager.getSessionBy(ctx.channel());
        session.getChannel_c().close();
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        try {
            ctx.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
