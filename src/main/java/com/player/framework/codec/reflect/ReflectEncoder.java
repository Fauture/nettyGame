package com.player.framework.codec.reflect;


import com.player.framework.codec.IMessageEncoder;
import com.player.framework.codec.reflect.serializer.Serializer;
import com.player.framework.serializer.Message;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectEncoder implements IMessageEncoder {

    private static Logger logger = LoggerFactory.getLogger(ReflectEncoder.class);

    @Override
    public byte[] writeMessageBody(Message message) {
        ByteBuf out = Unpooled.buffer();
        //写入具体消息的内容
        try {
            Serializer messageCodec = Serializer.getSerializer(message.getClass());
            messageCodec.encode(out, message, null);
        } catch (Exception e) {
            logger.error("读取消息出错,模块号{},异常{}", message.getModule(), e);
        }
        return out.array();
    }

}
