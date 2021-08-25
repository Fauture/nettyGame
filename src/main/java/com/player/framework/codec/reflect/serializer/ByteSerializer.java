package com.player.framework.codec.reflect.serializer;


import io.netty.buffer.ByteBuf;


public class ByteSerializer extends Serializer {

    @Override
    public Byte decode(ByteBuf in, Class<?> type, Class<?> wrapper) {
        return in.readByte();
    }

    @Override
    public void encode(ByteBuf out, Object value, Class<?> wrapper) {
        if (value instanceof Integer){
            out.writeByte( ((Integer) value).byteValue());
        }else if (value instanceof Short){
            out.writeByte(((Short) value).byteValue());
        }else if (value instanceof Long){
            out.writeByte( ((Long) value).byteValue());
        }else {
            out.writeByte( (byte) value);
        }
    }

}
