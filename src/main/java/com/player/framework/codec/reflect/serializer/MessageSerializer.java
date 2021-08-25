package com.player.framework.codec.reflect.serializer;


import com.player.framework.annotation.*;
import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;

public class MessageSerializer extends Serializer {

    private Logger logger = LoggerFactory.getLogger(MessageSerializer.class);
    private List<FieldCodecMeta> fieldsMeta;

    public static MessageSerializer valueOf(List<FieldCodecMeta> fieldsMeta) {
        MessageSerializer serializer = new MessageSerializer();
        serializer.fieldsMeta = fieldsMeta;
        return serializer;
    }

    @Override
    public Object decode(ByteBuf in, Class<?> type, Class<?> wrapper) {
        try {
            Object bean = type.newInstance();
            for (FieldCodecMeta fieldMeta : fieldsMeta) {
                Field field = fieldMeta.getField();
                Serializer fieldCodec = fieldMeta.getSerializer();
                Object value = null;
                if (fieldCodec instanceof StringSerializer) {
                    StringField stringField = field.getAnnotation(StringField.class);
                    StringSerializer stringSerializer = (StringSerializer) fieldCodec;
                    if (stringField != null) {
                        if (stringField.value() == 1) {
                            /**读取short长度的String*/
                            value = stringSerializer.decodeShort(in);
                        } else if (stringField.value() == 100) {
//                            value = ByteBuffUtil.readFullString(in);
                        } else {
                            /**默认读取byte长度的String*/
                            value = fieldCodec.decode(in, fieldMeta.getType(), fieldMeta.getWrapper());
                        }

                    } else {
                        /**默认读取byte长度的String*/
                        value = fieldCodec.decode(in, fieldMeta.getType(), fieldMeta.getWrapper());
                    }
                } else if (fieldCodec instanceof CollectionSerializer) {
                    ListField listField = field.getAnnotation(ListField.class);
                    CollectionSerializer collectionSerializer = (CollectionSerializer) fieldCodec;
                    if (listField != null) {
                        if (listField.value() == 1) {
                            /**读取byte长度的列表*/
                            value = collectionSerializer.decodeByte(in, fieldMeta.getType(), fieldMeta.getWrapper());
                        } else {
                            /**默认读取short长度的列表*/
                            value = fieldCodec.decode(in, fieldMeta.getType(), fieldMeta.getWrapper());
                        }
                    } else {
                        /**默认读取short长度的列表*/
                        value = fieldCodec.decode(in, fieldMeta.getType(), fieldMeta.getWrapper());
                    }
                } else {
                    /**其他类型没有特殊处理*/
                    value = fieldCodec.decode(in, fieldMeta.getType(), fieldMeta.getWrapper());
                }
                field.set(bean, value);
            }
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void encode(ByteBuf out, Object message, Class<?> wrapper) {
        if (message == null) {
            return;
        }
        Object value = null;
        try {
            byte valueType = -1;

            for (FieldCodecMeta fieldMeta : fieldsMeta) {
                Field field = fieldMeta.getField();
                Serializer fieldCodec = fieldMeta.getSerializer();
                value = field.get(message);
                if (valueType == 1 || valueType == 6) {
                    fieldCodec = Serializer.getSerializer(Byte.class);
                } else if (valueType == 2 || valueType == 7 || valueType == 85) {
                    fieldCodec = Serializer.getSerializer(Short.class);
                } else if (valueType == 4) {
                    fieldCodec = Serializer.getSerializer(String.class);
                } else if (valueType == 3) {
                    fieldCodec = Serializer.getSerializer(Integer.class);
                }

                if (fieldCodec instanceof StringSerializer) {
                    StringField stringField = field.getAnnotation(StringField.class);
                    StringSerializer stringSerializer = (StringSerializer) fieldCodec;
                    if (stringField != null) {
                        /**写入short长度的String*/
                        if (stringField.value() == 1) {
                            stringSerializer.encodeShort(out, (String) value);
                        } else if (stringField.value() == 100) {
//                            ByteBuffUtil.writeFullString(out, (String) value);
                        } else {
                            /**默认写入byte长度的String*/
                            fieldCodec.encode(out, value, fieldMeta.getWrapper());
                        }
                    } else {
                        /**默认写入byte长度的String*/
                        fieldCodec.encode(out, value, fieldMeta.getWrapper());
                    }
                } else if (fieldCodec instanceof CollectionSerializer) {
                    ListField listField = field.getAnnotation(ListField.class);
                    CollectionSerializer collectionSerializer = (CollectionSerializer) fieldCodec;
                    if (listField != null) {
                        collectionSerializer.encode(out, value, fieldMeta.getWrapper(), listField.value());
                    } else {
                        /**默认写入short长度的List*/
                        fieldCodec.encode(out, value, fieldMeta.getWrapper());
                    }
                } else if (fieldCodec instanceof ArraySerializer) {
                    ListField listField = field.getAnnotation(ListField.class);
                    ArraySerializer arraySerializer = (ArraySerializer) fieldCodec;
                    if (listField != null) {
                        arraySerializer.encode(out, value, fieldMeta.getWrapper(), listField.value());
                    } else {
                        fieldCodec.encode(out, value, fieldMeta.getWrapper());
                    }
                }else if (fieldCodec instanceof LongSerializer){
                    LongField longField = field.getAnnotation(LongField.class);
                    if (longField !=null &&longField.value() == 1){
                        LongSerializer longSerializer = (LongSerializer) fieldCodec;
                        longSerializer.encodeUnsignedInt(out, value, fieldMeta.getWrapper());
                    }else {
                        fieldCodec.encode(out, value, fieldMeta.getWrapper());
                    }
                }else if (fieldCodec instanceof IntSerializer){
                    IntegerField integerField = field.getAnnotation(IntegerField.class);
                    if (integerField != null && integerField.value() == 1){
                        IntSerializer intSerializer = (IntSerializer) fieldCodec;
                        intSerializer.encodeUnsignedShort(out, value, fieldMeta.getWrapper());
                    }else {
                        fieldCodec.encode(out, value, fieldMeta.getWrapper());
                    }
                }else if (fieldCodec instanceof ShortSerializer){
                    ShortField shortField = field.getAnnotation(ShortField.class);
                    if (shortField != null && shortField.value() == 1){
                        ShortSerializer shortSerializer = (ShortSerializer)fieldCodec;
                        shortSerializer.encodeUnsignedByte(out, value, fieldMeta.getWrapper());
                    }else {
                        fieldCodec.encode(out, value, fieldMeta.getWrapper());
                    }
                } else {
                    /**其他类型没有特殊处理*/
                    fieldCodec.encode(out, value, fieldMeta.getWrapper());
                }

                if (field.getName().equals("VT")) {
                    valueType = (byte) value;
                }

            }
        } catch (Exception e) {
            logger.error("{}{}{}", e, message,message.getClass().getName());
        }
    }

}
