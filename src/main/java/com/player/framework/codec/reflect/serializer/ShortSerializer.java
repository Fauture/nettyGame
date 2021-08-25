package com.player.framework.codec.reflect.serializer;


import io.netty.buffer.ByteBuf;


public class ShortSerializer extends Serializer {

    @Override
    public Short decode(ByteBuf in, Class<?> type, Class<?> wrapper) {
        return in.readShort();
    }

    @Override
    public void encode(ByteBuf out, Object value, Class<?> wrapper) {
        if (value instanceof Long) {
            out .writeShort( ((Long) value).shortValue());
        } else if (value instanceof Integer) {
            out.writeShort(((Integer) value).shortValue());
        } else if (value instanceof Byte) {
            out.writeShort( ((Byte) value).shortValue());
        } else {
            out.writeShort((short) value);
        }
    }

    public void encodeUnsignedByte(ByteBuf out, Object value, Class<?> wrapper) {
        if (value instanceof Long) {
            out.writeBytes(out, ((Long) value).shortValue());
        } else if (value instanceof Integer) {
            out.writeBytes(out, ((Integer) value).shortValue());
        } else if (value instanceof Byte) {
            value = ((Byte) value).shortValue();
            out.writeBytes(out, ((Byte) value).shortValue());
        } else {
            out.writeBytes(out, (short) value);
        }
    }

}
