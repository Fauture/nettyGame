package com.player.game.messages.login;


import com.player.framework.annotation.message.MessageMeta;
import com.player.framework.serializer.Message;
import com.player.game.Module;

@MessageMeta(module = Module.PLAYER)
public class ReqUserLogin extends Message {

	public String uname;

	public String upwd;

	@Override
	public String toString() {
		return "ReqUserLogin{" +
				"uname='" + uname + '\'' +
				", upwd='" + upwd + '\'' +
				'}';
	}
}
