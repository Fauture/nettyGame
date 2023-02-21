package com.player.game.npc;

import com.player.framework.annotation.message.MessageMeta;
import com.player.framework.serializer.Message;

import com.player.server.Cmd;
import com.player.server.Module;

@MessageMeta(cmd = Cmd.ORIGINAL, module = Module.CMD_SELECT_MENU_ITEM)
public class ReqNpcTalk extends Message {
	private NpcTalk NpcTalk;

	public com.player.game.npc.NpcTalk getNpcTalk() {
		return NpcTalk;
	}

	public void setNpcTalk(com.player.game.npc.NpcTalk npcTalk) {
		NpcTalk = npcTalk;
	}

	public ReqNpcTalk() {
	}

	public ReqNpcTalk(com.player.game.npc.NpcTalk npcTalk) {
		NpcTalk = npcTalk;
	}
}
