package com.player.game.controllers;

import com.player.framework.annotation.message.Controller;
import com.player.framework.annotation.message.RequestMapping;
import com.player.framework.net.IdSession;
import com.player.game.messages.player.ReqRuckSack;
import com.player.game.messages.player.ReqSelectPlayer;
import com.player.game.servers.PlayerServer;

@Controller
public class PlayerController {

	@RequestMapping
	public void reqSelectPlayer(IdSession session, ReqSelectPlayer request) {
		System.err.println(request.toString());
//		PlayerServer.getInstance().reqSelectPlayer(session, request);
	}

	@RequestMapping
	public void reqRuckSack(IdSession session, ReqRuckSack request) {

//		PlayerServer.getInstance().reqRuckSack(session, request);
	}

}
