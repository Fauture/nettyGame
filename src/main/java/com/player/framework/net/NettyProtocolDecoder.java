package com.player.framework.net;

import java.util.List;

import com.player.framework.codec.IMessageDecoder;
import com.player.framework.codec.SerializerHelper;
import com.player.framework.serializer.Message;
import com.player.framework.serializer.MessageFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class NettyProtocolDecoder extends ByteToMessageDecoder {

    private int moduleLength = 2;

    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        try {
            int crc = in.readShort();
            int time = in.readInt();
            int length = in.readShort();
            int moduleId = in.readShort();
            //System.err.println("time:" + crc + " time:" + time + " length:" + length + " moduleId:" + moduleId);
            byte[] bytes = new byte[length - moduleLength];
            in.readBytes(bytes);
            Class<?> msgClazz = MessageFactory.INSTANCE.getMessage(moduleId, 0);
            if (msgClazz == null) {
                return;
            }
            IMessageDecoder msgDecoder = SerializerHelper.getInstance().getDecoder();
            try {
                Message msg = msgDecoder.readMessage(moduleId, (short) 0, bytes);
                out.add(msg);
            } catch (Exception e) {
                throw new Exception(e);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}