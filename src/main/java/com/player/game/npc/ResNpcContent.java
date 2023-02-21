package com.player.game.npc;

import com.player.framework.annotation.StringField;
import com.player.framework.annotation.message.MessageMeta;
import com.player.framework.serializer.Message;
import com.player.server.Cmd;
import com.player.server.Module;


@MessageMeta(cmd = Cmd.ORIGINAL, module = Module.MSG_MENU_LIST)
public class ResNpcContent extends Message {

	private int id;
	private int icon;
	private short type;

	@StringField(1)
	private String text;
	private int unknown;

	private String name;
	private short unknown_1;
	private short unknown_2;
	private byte unknown_3;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
