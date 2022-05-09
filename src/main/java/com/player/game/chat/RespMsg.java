package com.player.game.chat;


import com.player.framework.annotation.StringField;
import com.player.framework.annotation.message.MessageIgnore;
import com.player.framework.annotation.message.MessageMeta;
import com.player.framework.serializer.Message;
import com.player.server.Cmd;
import com.player.server.Module;

@MessageIgnore()
@MessageMeta(cmd = Cmd.ORIGINAL, module = Module.MSG_DIALOG_OK)
public class RespMsg extends Message {
   
    @StringField(1)
    private String msg;
   
    private short active = 0;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public RespMsg(String msg) {
        this.msg = msg;
    }

    public RespMsg() {
    }
}
