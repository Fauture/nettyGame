package com.player.framework.codec.reflect;



import com.player.framework.codec.IMessageDecoder;
import com.player.framework.codec.reflect.serializer.Serializer;
import com.player.framework.serializer.Message;
import com.player.framework.serializer.MessageFactory;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectDecoder implements IMessageDecoder {

    private static Logger logger = LoggerFactory.getLogger(ReflectDecoder.class);

    @Override
    public Message readMessage(int module, int cmd, byte[] body) {
        ByteBuf in = Unpooled.buffer(body.length);
        in.writeBytes(body);
        Class<?> msgClazz = MessageFactory.INSTANCE.getMessage(module, cmd);
        if (msgClazz == null) {
            return null;
        }
        try {
            Serializer messageCodec = Serializer.getSerializer(msgClazz);
            return (Message) messageCodec.decode(in, msgClazz, null);
        } catch (Exception e) {
            logger.error("读取消息出错,模块号{},异常{}", module, e);
        } finally {
            ReferenceCountUtil.release(in);
        }
        return null;
    }
}
