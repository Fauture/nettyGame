package com.player.framework.net;

import com.player.framework.codec.IMessageEncoder;
import com.player.framework.codec.SerializerHelper;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import com.player.framework.serializer.Message;

/**
 * 组合包体
 */
public class NettyProtocolEncoder extends MessageToByteEncoder<Message> {

    private int moduleLength = 2;

    protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf out) throws Exception {
        try {
            out.writeByte(77);
            out.writeByte(90);
            out.writeShort(0);
            out.writeInt(message.getTime());
            int moduleId = message.getModule() == 0 ? message.getCmd_() : message.getModule();
            IMessageEncoder msgEncoder = SerializerHelper.getInstance().getEncoder();
            byte[] body = msgEncoder.writeMessageBody(message);
            out.writeShort(body.length + moduleLength);
            out.writeShort(moduleId);
            out.writeBytes(body);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
