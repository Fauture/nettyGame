package com.player.framework.codec.reflect.serializer;


import io.netty.buffer.ByteBuf;


import java.lang.reflect.Modifier;
import java.util.*;

/**
 * 集合属性序列化
 * 注：由于集合元素bean没有像Message一样注册id，
 * 因此集合的元素不能是父类或抽象类
 */
public class CollectionSerializer extends Serializer {

    @Override
    public Object decode(ByteBuf in, Class<?> type, Class<?> wrapper) {
        int size = in.readShort();
        return getObject(in, type, wrapper, size);
    }


    public Object decodeByte(ByteBuf in, Class<?> type, Class<?> wrapper) {
        int size = in.readByte();
        return getObject(in, type, wrapper, size);
    }

    private Object getObject(ByteBuf in, Class<?> type, Class<?> wrapper, int size) {
        int modifier = type.getModifiers();
        Collection<Object> result = null;

        if (Modifier.isAbstract(modifier) || Modifier.isInterface(modifier)) {
            if (List.class.isAssignableFrom(type)) {
                result = new ArrayList<>();
            } else if (Set.class.isAssignableFrom(type)) {
                result = new HashSet<>();
            }
        } else {
            try {
                result = (Collection) type.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                result = new ArrayList<>();
            }
        }

        for (int i = 0; i < size; i++) {
            Serializer fieldCodec = Serializer.getSerializer(wrapper);
            Object eleValue = fieldCodec.decode(in, wrapper, null);
            result.add(eleValue);
        }

        return result;
    }

    @Override
    public void encode(ByteBuf out, Object value, Class<?> wrapper) {
        if (value == null) {
            out.writeShort((short) 0);
            return;
        }
        Collection<Object> collection = (Collection) value;
        int size = collection.size();
        out.writeShort((short) size);

        for (Object elem : collection) {
            Class<?> clazz = elem.getClass();
            Serializer fieldCodec = Serializer.getSerializer(clazz);
            fieldCodec.encode(out, elem, wrapper);
        }
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
        Collection<Object> collection = (Collection) value;
        int size = collection.size();
        if (type == 1) {
            out.writeByte((byte) size);
        } else if (type == 2) {
        } else if (type == 3) {
            out.writeInt(size);
        } else {
            out.writeShort((short) size);
        }

        for (Object elem : collection) {
            Class<?> clazz = elem.getClass();
            Serializer fieldCodec = Serializer.getSerializer(clazz);
            fieldCodec.encode(out, elem, wrapper);
        }
    }

}
