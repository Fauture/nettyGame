package com.player.framework.client;

import com.player.framework.net.IdSession;
import com.player.framework.net.MessageDispatcherFactory;
import com.player.framework.serializer.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    private MessageDispatcherFactory messageDispatcher;

    private IdSession idSession;

    public NettyClientHandler(MessageDispatcherFactory messageDispatcher, IdSession idSession) {
        super();
        this.messageDispatcher = messageDispatcher;
        this.idSession = idSession;
    }

    /**
     * 进入连接
     * @param ctx
     * @throws Exception
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        idSession.setChannel_c(ctx.channel());
    }

    /**
     * 接收消息
     * @param ctx
     * @param msg
     * @throws Exception
     */
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        this.messageDispatcher.dispatch(idSession, (Message) msg);
    }

    /**
     * 断开连接
     * @param ctx
     * @throws Exception
     */
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //IdSession session = ChannelSession.getPlayerSession(ctx.channel());
        //this.messageDispatcher.onSessionClosed(session);
        idSession.getChannel().close();
    }


    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        try {
            ctx.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}