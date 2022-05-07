package com.player.framework.net;

import com.player.framework.serializer.Message;
import io.netty.channel.Channel;

public interface IdSession {


	public Channel getChannel();
	public Channel getChannel_c();

	public long getPlayerId();

	public Object getAttribute(String key);

	public void setAttribute(String key, Object value);

	public void setChannel_c(Channel channel_c);

	public void send(Message message);

	public void c_send(Message message);
}
