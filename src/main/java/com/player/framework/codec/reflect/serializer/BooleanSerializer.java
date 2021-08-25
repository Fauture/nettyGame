package com.player.framework.codec.reflect.serializer;


import io.netty.buffer.ByteBuf;


public class BooleanSerializer extends Serializer {

    @Override
    public Boolean decode(ByteBuf in, Class<?> type, Class<?> wrapper) {
        return in.readBoolean();
    }

    @Override
    public void encode(ByteBuf out, Object value, Class<?> wrapper) {
        out.writeBoolean( (boolean) value);
    }

}
