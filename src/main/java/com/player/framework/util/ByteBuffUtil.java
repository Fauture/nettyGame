package com.player.framework.util;

import io.netty.buffer.ByteBuf;
import java.nio.charset.Charset;

public class ByteBuffUtil {
    public static final Charset DEFAULT_CHARSET = Charset.forName("GBK");

    /**
     * 读byte长度的String
     */
    public static String readByteString(ByteBuf cb) throws IndexOutOfBoundsException {
        int length = cb.readUnsignedByte();
        return getString(cb, length);
    }

    /**
     * 读short长度的String
     */
    public static String readShortString(ByteBuf cb) throws IndexOutOfBoundsException {
        int length = cb.readUnsignedShort();
        return getString(cb, length);
    }

    /**
     * 读int长度的String
     */
    public static String readFullString(ByteBuf cb) throws IndexOutOfBoundsException {
        int length = cb.readInt();
        return getString(cb, length);
    }

    private static String getString(ByteBuf cb, int length) {
        if (length == 0) {
            return "";
        }
        if ((length > 0) && (length <= cb.readableBytes())) {
            byte[] strByte = new byte[length];
            cb.readBytes(strByte);
            return readString(strByte);
        }
        throw new IndexOutOfBoundsException(length + "字符串长度不够 ! ");
    }


    public static String readString(byte[] bytes) {
        return new String(bytes, DEFAULT_CHARSET);
    }


    /**
     * 写byte长度的String
     */
    public static void writeByteString(ByteBuf buff, String value) {
        if (value == null) {
            buff.writeByte(0);
            return;
        }
        byte[] bytes = value.getBytes(DEFAULT_CHARSET);

        buff.writeByte(bytes.length);
        buff.writeBytes(bytes);
    }

    /**
     * 写short长度的String
     */
    public static void writeShortString(ByteBuf buff, String value) {
        if (value == null) {
            buff.writeShort(0);
            return;
        }
        byte[] bytes = value.getBytes(DEFAULT_CHARSET);
        buff.writeShort(bytes.length);
        buff.writeBytes(bytes);
    }

    /**
     * 写int长度的String
     */
    public static void writeFullString(ByteBuf buff, String value) {
        if (value == null) {
            buff.writeShort(0);
            return;
        }
        byte[] bytes = value.getBytes(DEFAULT_CHARSET);
        buff.writeInt(bytes.length);
        buff.writeBytes(bytes);
    }

}
