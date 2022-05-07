package com.player.game.npc;


import com.player.framework.annotation.message.MessageMeta;
import com.player.framework.serializer.Message;
import com.player.server.Module;

@MessageMeta(module = Module.MSG_MENU_CLOSED)
public class RespNpcLeave extends Message {
    private int npcId;

    public int getNpcId() {
        return npcId;
    }

    public void setNpcId(int npcId) {
        this.npcId = npcId;
    }
}
