package com.player.game.role;

import com.player.framework.annotation.message.MessageMeta;
import com.player.framework.serializer.Message;
import com.player.server.Cmd;
import com.player.server.Module;

//@MessageIgnore()
@MessageMeta(cmd = Cmd.ORIGINAL, module = Module.CMD_UP_SKILLS)
public class ReqUpSkill extends Message {

    /**
     * 学习npcId
     */
    private int npcId = 0;
    /**
     * 学习者id
     */
    private int id = 0;
    /**
     * 技能id
     */
    private short no = 0;


    public int getNpcId() {
        return npcId;
    }

    public void setNpcId(int npcId) {
        this.npcId = npcId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public short getNo() {
        return no;
    }

    public void setNo(short no) {
        this.no = no;
    }
}
