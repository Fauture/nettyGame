package com.player.framework.net;

import com.player.framework.serializer.Message;
import com.player.game.CharData;
import io.netty.channel.Channel;

public interface IdSession {


	public Channel getChannel();
	public Channel getChannel_c();

	public long getPlayerId();

	public Object getAttribute(String key);

	public void setAttribute(String key, Object value);

	public void setChannel_c(Channel channel_c);

	/**
	 * 服务端发玩家
	 * @param message
	 */
	public void send(Message message);
	/**
	 * 玩家发服务端
	 * @param message
	 */
	public void c_send(Message message);

	/**
	 * 玩家数据
	 * @return
	 */
	public CharData getCharData();


}
