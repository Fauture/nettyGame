package com.player.framework.codec.reflect.serializer;


import io.netty.buffer.ByteBuf;


public class LongSerializer extends Serializer {

    @Override
    public Long decode(ByteBuf in, Class<?> type, Class<?> wrapper) {
        return in.readLong();
    }

    @Override
    public void encode(ByteBuf out, Object value, Class<?> wrapper) {
        out.writeLong( (long) value);
    }
    public void encodeUnsignedInt(ByteBuf out, Object value, Class<?> wrapper) {
        out.writeLong((long) value);
    }
}
