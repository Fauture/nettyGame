package com.player.framework.serializer;

import com.player.framework.annotation.message.MessageMeta;

public class Message {

	private short cmd_;

	private int time;

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setCmd_(short cmd_) {
		this.cmd_ = cmd_;
	}

	public short getCmd_() {
		return cmd_;
	}

	public short getModule() {
		MessageMeta annotation = getClass().getAnnotation(MessageMeta.class);
		if (annotation != null) {
			return annotation.module();
		}
		return 0;
	}

	public short getCmd() {
		MessageMeta annotation = getClass().getAnnotation(MessageMeta.class);
		if (annotation != null) {
			return annotation.cmd();
		}
		return 0;
	}







}
