package com.player.framework.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import com.player.framework.serializer.Message;

public class NettyProtocolEncoder extends MessageToByteEncoder<Message> {

	protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf out) throws Exception {
//		try {
//			short module = message.getModule();
//			short cmd = message.getCmd();
//			byte[] body = Serializer.encode(message);
//			out.writeShortLE(this.length + body.length);
//			out.writeShortLE(module);
//			out.writeShortLE(cmd);
//			out.writeIntLE(0);
//			out.writeBytes(body);
//		} catch (Exception e) {
//			throw new Exception(e);
//		}
	}

}
