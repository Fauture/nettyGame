package com.player.framework.net;

import java.util.HashMap;
import java.util.Map;

import com.player.framework.client.NettyClient;
import com.player.framework.serializer.Message;
import io.netty.channel.Channel;

public class PlayerSession implements IdSession {


	private Channel channel_c;
	private Channel channel;
	private Map<String, Object> container = new HashMap<>();

	public PlayerSession(Channel channel) throws InterruptedException {
		super();
		this.channel = channel;
		NettyClient nettyClient = new NettyClient();
		this.channel_c = nettyClient.connect("192.168.200.128",8160,this);
//		this.channel_c = nettyClient.connect("192.168.200.1",8888,this);
	}

	public void setChannel_c(Channel channel_c) {
		this.channel_c = channel_c;
	}

	public Channel getChannel() {
		return this.channel;
	}

	public Channel getChannel_c() {
		return this.channel_c;
	}

	public long getPlayerId() {
		if (this.container.containsKey(PropertySession.PLAYER_ID)) {
			return (long) this.container.get(PropertySession.PLAYER_ID);
		}
		return 0;
	}

	public Object getAttribute(String key) {
		return this.container.get(key);
	}

	public void setAttribute(String key, Object value) {
		this.container.put(key, value);
	}

	public void send(Message message) {
		channel.writeAndFlush(message);
	}

	public void c_send(Message message) {
		channel_c.writeAndFlush(message);
	}

}
