package com.player.framework.codec.reflect.serializer;


import com.player.framework.util.ReflectUtil;
import io.netty.buffer.ByteBuf;

import java.lang.reflect.Array;

/**
 * 数组属性序列化
 * 注：由于数组元素bean没有像Message一样注册id，
 * 因此数组的元素不能是父类或抽象类
 */
public class ArraySerializer extends Serializer {

    @Override
    public Object decode(ByteBuf in, Class<?> type, Class<?> wrapper) {
        int size = in.readShort();
        Object array = ReflectUtil.newArray(type, wrapper, size);

        for (int i = 0; i < size; i++) {
            Serializer fieldCodec = getSerializer(wrapper);
            Object eleValue = fieldCodec.decode(in, wrapper, null);
            Array.set(array, i, eleValue);
        }

        return array;
    }

    @Override
    public void encode(ByteBuf out, Object value, Class<?> wrapper) {
        if (value == null) {
            out.writeShort((short) 0);
            return;
        }
        int size = Array.getLength(value);
        out.writeShort((short) size);
        encodeObject(out, value, wrapper, size);
    }

    public void encode(ByteBuf out, Object value, Class<?> wrapper, int type) {
        if (value == null) {
            if (type == 1) {
                out.writeByte((byte) 0);
            } else if (type == 2) {
            } else if (type == 3) {
                out.writeInt(0);
            } else {
                out.writeShort((short) 0);
            }
            return;
        }
        int size = Array.getLength(value);
        if (type == 1) {
            out.writeByte((byte) size);
        } else if (type == 2) {
        } else if (type == 3) {
            out.writeInt(size);
        } else {
            out.writeShort((short) size);
        }
        encodeObject(out, value, wrapper, size);
    }

    private void encodeObject(ByteBuf out, Object value, Class<?> wrapper, int size) {
        for (int i = 0; i < size; i++) {
            Object elem = Array.get(value, i);
            Class<?> clazz = elem.getClass();
            Serializer fieldCodec = getSerializer(clazz);
            fieldCodec.encode(out, elem, wrapper);
        }
    }

}
