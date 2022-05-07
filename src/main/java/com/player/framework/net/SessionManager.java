package com.player.framework.net;


import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class SessionManager {

    private static  Map<Channel, IdSession> sSessions = new ConcurrentHashMap<>();

    public static void add2Anonymous(IdSession session) {
        sSessions.put(session.getChannel(), session);
    }

    public static void removeFromAnonymous(IdSession session) {
        sSessions.remove(session.getChannel());
    }

    public static IdSession getSessionBy(Channel playerId) {
        return sSessions.get(playerId);
    }

}
