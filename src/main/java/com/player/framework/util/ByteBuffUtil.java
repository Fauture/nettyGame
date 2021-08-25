package com.player.framework.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.nio.charset.Charset;

public class ByteBuffUtil {
	public static final Charset DEFAULT_CHARSET = Charset.forName("GBK");

	/**
	 * 取一个长度字符串
	 * @param cb
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public static String readByteString(ByteBuf cb) throws IndexOutOfBoundsException {
		int lenght = readUnsignedByte(cb);
		if (lenght == 0) {
			return "";
		}
		if ((lenght > 0) && (lenght <= cb.readableBytes())) {
			byte[] strByte = new byte[lenght];
			cb.readBytes(strByte);
			return readString(strByte);
		}
		throw new IndexOutOfBoundsException("字符串长度不够 ! ");
	}

	/**
	 * 取两个长度字符串
	 * @param cb
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public static String readShortString(ByteBuf cb) throws IndexOutOfBoundsException {
		int lenght = cb.readUnsignedShort();
		if (lenght == 0) {
			return "";
		}
		if ((lenght > 0) && (lenght <= cb.readableBytes())) {
			byte[] strByte = new byte[lenght];
			cb.readBytes(strByte);
			return readString(strByte);
		}
		throw new IndexOutOfBoundsException(lenght+"字符串长度不够 ! ");
	}

	public static String readString(byte[] bytes) {
		return new String(bytes, DEFAULT_CHARSET);
	}

	public static int readUnsignedByte(ByteBuf cb) {
		return cb.readUnsignedByte();
	}


	/**
	 * 一个长度文本
	 *
	 * @param buff
	 * @param value
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
	 * 两个长度文本
	 *
	 * @param buff
	 * @param value
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







}
