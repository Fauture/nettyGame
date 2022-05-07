package com.player.server.message;


import com.player.framework.annotation.ListField;
import com.player.framework.annotation.message.MessageMeta;
import com.player.framework.serializer.Message;

@MessageMeta()
public class ResRaw extends Message {

    public ResRaw(int time, short cmd) {
        setCmd_(cmd);
        setTime(time);
    }

    @ListField(2)
    private byte[] bytes;

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
