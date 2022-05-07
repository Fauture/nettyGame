package com.player.framework.net;

import java.util.List;

import com.player.framework.codec.IMessageDecoder;
import com.player.framework.codec.SerializerHelper;
import com.player.framework.serializer.Message;
import com.player.framework.serializer.MessageFactory;
import com.player.server.message.ResRaw;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class NettyProtocolDecoder extends ByteToMessageDecoder {

    private int moduleLength = 2;

    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        try {
            in.readShort();
            in.readShort();
            int time = in.readInt();
            int length = in.readShort();
            int moduleId = in.readShort() & 0xffff;
            byte[] bytes = new byte[length - moduleLength];
            in.readBytes(bytes);
            Class<?> msgClazz = MessageFactory.INSTANCE.getMessage(moduleId, 0);
            System.err.println("msgClazz:" + msgClazz + " time:" + time + " length:" + length + " moduleId:" + moduleId);
            if (msgClazz == null) {
                ResRaw reqRaw = new ResRaw(time, (short) moduleId);
                reqRaw.setBytes(bytes);
                out.add(reqRaw);
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
