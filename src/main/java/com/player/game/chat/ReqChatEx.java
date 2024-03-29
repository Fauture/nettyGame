package com.player.game.chat;


import com.player.framework.annotation.ListField;
import com.player.framework.annotation.StringField;
import com.player.framework.annotation.message.MessageMeta;
import com.player.framework.serializer.Message;
import com.player.server.Cmd;
import com.player.server.Module;

import java.util.List;

@MessageMeta(cmd = Cmd.ORIGINAL, module = Module.CMD_CHAT_EX)
public class ReqChatEx extends Message {
    /**
     * 类型
     */
    private short channel;
    private short compress;
    private short orgLength;

    @StringField(1)
    private String msg;

    /**
     * 名片
     */
    @ListField()
    private List<Card> Card;

    public static class Card {
        public Card() {
        }
        private String id;
        private byte type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public byte getType() {
            return type;
        }

        public void setType(byte type) {
            this.type = type;
        }
    }

    public short getChannel() {
        return channel;
    }

    public void setChannel(short channel) {
        this.channel = channel;
    }

    public short getCompress() {
        return compress;
    }

    public void setCompress(short compress) {
        this.compress = compress;
    }

    public short getOrgLength() {
        return orgLength;
    }

    public void setOrgLength(short orgLength) {
        this.orgLength = orgLength;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ReqChatEx.Card> getCard() {
        return Card;
    }

    public void setCard(List<ReqChatEx.Card> card) {
        Card = card;
    }
}
