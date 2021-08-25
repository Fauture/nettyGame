package com.player.framework.codec;


import com.player.framework.serializer.Message;

public interface IMessageEncoder {

    /**
     * 把一个具体的消息序列化byte[]
     *
     * @param message
     * @return
     */
    byte[] writeMessageBody(Message message);

}
