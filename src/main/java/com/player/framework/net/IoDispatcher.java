package com.player.framework.net;

import com.player.framework.serializer.Message;

public interface IoDispatcher {

	public void onSessionCreated(IdSession session);

	public boolean dispatch(IdSession session, Message message);

	public void onSessionClosed(IdSession session);

}
