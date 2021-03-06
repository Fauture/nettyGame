package com.player.framework.util;

import java.util.concurrent.atomic.AtomicLong;

import com.player.server.ServerConfig;

public class ToolUtil {

	private static AtomicLong atomicLong = new AtomicLong(0);

	public static int getRandom(int min, int max) {
		return min + (int) (Math.random() * (max - min + 1));
	}

	public static long getId() {
		long serverId = 10000;
		return (serverId << 48) | (((System.currentTimeMillis() / 1000) & 0xFFFFFFFF) << 16)
				| (atomicLong.getAndIncrement() & 0xFFFF);
	}

}
