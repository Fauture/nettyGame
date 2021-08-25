package com.player.framework.codec.reflect.serializer;


import com.player.framework.util.ByteBuffUtil;
import io.netty.buffer.ByteBuf;


public class StringSerializer extends Serializer {

    /**默认byte长度String*/
    @Override
    public String decode(ByteBuf in, Class<?> type, Class<?> wrapper) {
        return ByteBuffUtil.readByteString(in);
    }

    /**short长度String*/
    public String decodeShort(ByteBuf in) {
        return ByteBuffUtil.readShortString(in);
    }

    /**short长度String*/
    public void encodeShort(ByteBuf out, String msg) {
        ByteBuffUtil.writeShortString(out, msg);
    }


    /**默认byte长度String*/
    @Override
    public void encode(ByteBuf out, Object value, Class<?> wrapper) {
        ByteBuffUtil.writeByteString(out, (String) value);
    }

}
