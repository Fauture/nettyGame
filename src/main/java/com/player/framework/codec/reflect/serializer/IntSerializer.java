package com.player.framework.codec.reflect.serializer;

import io.netty.buffer.ByteBuf;


public class IntSerializer extends Serializer {

    @Override
    public Integer decode(ByteBuf in, Class<?> type, Class<?> wrapper) {
        return in.readInt();
    }

    @Override
    public void encode(ByteBuf out, Object value, Class<?> wrapper) {
        if (value instanceof Short) {
            out.writeInt(((Short) value).intValue());
        } else if (value instanceof Long) {
            out.writeInt(((Long) value).intValue());
        } else if (value instanceof Byte) {
            out.writeInt(((Byte) value).intValue());
        } else {
            out.writeInt((int) value);
        }
    }

    public void encodeUnsignedShort(ByteBuf out, Object value, Class<?> wrapper) {
        if (value instanceof Short) {
            out.writeShort(((Short) value).intValue());
        } else if (value instanceof Long) {
            out.writeShort(((Long) value).intValue());
        } else if (value instanceof Byte) {
            out.writeShort(((Byte) value).intValue());
        } else {
            out.writeShort((int) value);
        }
    }
}
