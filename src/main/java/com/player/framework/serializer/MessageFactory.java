package com.player.framework.serializer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.player.framework.annotation.message.MessageIgnore;
import com.player.framework.annotation.message.MessageMeta;
import com.player.framework.util.ClassScanner;

public enum MessageFactory {

    INSTANCE;

    private Map<Integer, Class<?>> id2Clazz = new HashMap<>();
    private Map<Class<?>, Integer> clazz2Id = new HashMap<>();

    public void initialize(String packageName) throws Exception {
        try {
            System.out.println("Loading message meta...");
            Set<Class<?>> result = ClassScanner.getDeclaredSubClass(packageName, Message.class);
            for (Class<?> clazz : result) {
                MessageMeta meta = clazz.getAnnotation(MessageMeta.class);
                if (meta == null) {
                    throw new RuntimeException("Messages[" + clazz.getSimpleName() + "] missed MessageMeta annotation");
                }
                int key = key(meta.module(), meta.cmd());
                MessageIgnore ignore = clazz.getAnnotation(MessageIgnore.class);
                if (ignore != null) {
                    System.out.println("MessageIgnore Message meta [" + key + "] clazz[" + clazz + "]");
                    continue;
                }
                System.out.println("Message meta [" + key + "] clazz[" + clazz + "]");
                if (id2Clazz.containsKey(key)) {
                    throw new RuntimeException("Message meta [" + key + "] duplicate clazz[" + clazz + "]");
                }
                id2Clazz.put(key, clazz);
                clazz2Id.put(clazz, key);
            }
            System.out.println("Loading message meta[" + id2Clazz.size() + "] successfully!");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Class<?> getMessage(int module, int cmd) {
        return id2Clazz.get(key(module, cmd));
    }

    public Class<?> getMessageById(int id) {
        int module = (int) (id / 1000);
        int cmd = (int) (id % 1000);
        return id2Clazz.get(key(module, cmd));
    }

    public int getIdByMessage(Class<?> clazz) {
        return clazz2Id.get(clazz);
    }

    public short[] getMessageMeta(Method method) {
        for (Class<?> clazz : method.getParameterTypes()) {
            if (Message.class.isAssignableFrom(clazz)) {
                MessageMeta protocol = clazz.getAnnotation(MessageMeta.class);
                if (protocol != null) {
                    return new short[]{protocol.module(), protocol.cmd()};
                }
            }
        }
        return null;
    }

    public int key(int module, int cmd) {
        return module + cmd * 100000;
    }

}
