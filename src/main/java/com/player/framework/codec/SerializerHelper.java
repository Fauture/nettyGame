package com.player.framework.codec;


import com.player.framework.codec.reflect.ReflectDecoder;
import com.player.framework.codec.reflect.ReflectEncoder;

public class SerializerHelper {

    public static volatile SerializerHelper instance;

    private IMessageDecoder decoder;

    private IMessageEncoder encoder;

    public static SerializerHelper getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (SerializerHelper.class) {
            if (instance == null) {
                instance = new SerializerHelper();
                instance.initialize();
            }
        }
        return instance;
    }

    private void initialize() {
        decoder = new ReflectDecoder();
        encoder = new ReflectEncoder();
    }


    public IMessageDecoder getDecoder() {
        return decoder;
    }

    public IMessageEncoder getEncoder() {
        return encoder;
    }

}
