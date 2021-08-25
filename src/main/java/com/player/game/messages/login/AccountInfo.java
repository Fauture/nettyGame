package com.player.game.messages.login;

public class AccountInfo {

	private byte id;

	private short id1;

	private int id2;

	private String unick;

	@Override
	public String toString() {
		return "AccountInfo{" +
				"id=" + id +
				", id1=" + id1 +
				", id2=" + id2 +
				", unick='" + unick + '\'' +
				'}';
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

	public String getUnick() {
		return unick;
	}

	public void setUnick(String unick) {
		this.unick = unick;
	}
}
