package com.player.game.messages.login;

import com.player.framework.annotation.message.MessageMeta;
import com.player.framework.serializer.Message;
import com.player.game.Module;

@MessageMeta(module = Module.TEST)
public class ResGuestLogin extends Message {

	private int status;

	private AccountInfo uinfo;


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public AccountInfo getUinfo() {
		return uinfo;
	}

	public void setUinfo(AccountInfo uinfo) {
		this.uinfo = uinfo;
	}
}
