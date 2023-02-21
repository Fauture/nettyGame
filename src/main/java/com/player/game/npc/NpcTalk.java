package com.player.game.npc;

public class NpcTalk {
    private int npcId;
    /**
     * 消息
     */
    private String msg;
    /**
     * 对话附加项
     */
    private String para;

    public int getNpcId() {
        return npcId;
    }

    public void setNpcId(int npcId) {
        this.npcId = npcId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }
}
