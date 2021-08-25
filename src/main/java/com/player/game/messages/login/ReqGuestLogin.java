package com.player.game.messages.login;


import com.player.framework.annotation.StringField;
import com.player.framework.annotation.message.MessageMeta;
import com.player.framework.serializer.Message;
import com.player.game.Module;

import java.util.List;


@MessageMeta(module = Module.LOGIN)
public class ReqGuestLogin extends Message {
	private byte id;

	private short id1;
	private int id2;

	private String guestKey;

	@StringField(1)
	private String guestKey1;

	private AccountInfo accountInfo;

	private List<AccountInfo> accountInfos;

	@Override
	public String toString() {
		return "ReqGuestLogin{" +
				"id=" + id +
				", id1=" + id1 +
				", id2=" + id2 +
				", guestKey='" + guestKey + '\'' +
				", guestKey1='" + guestKey1 + '\'' +
				", accountInfo=" + accountInfo +
				", accountInfos=" + accountInfos +
				'}';
	}

	public String getGuestKey1() {
		return guestKey1;
	}

	public void setGuestKey1(String guestKey1) {
		this.guestKey1 = guestKey1;
	}

	public List<AccountInfo> getAccountInfos() {
		return accountInfos;
	}

	public void setAccountInfos(List<AccountInfo> accountInfos) {
		this.accountInfos = accountInfos;
	}

	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public short getId1() {
		return id1;
	}

	public void setId1(short id1) {
		this.id1 = id1;
	}

	public int getId2() {
		return id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}

	public String getGuestKey() {
		return guestKey;
	}

	public void setGuestKey(String guestKey) {
		this.guestKey = guestKey;
	}

	public AccountInfo getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}
}