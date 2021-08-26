package com.player.game.controllers;

import com.player.framework.annotation.message.Controller;
import com.player.framework.annotation.message.RequestMapping;
import com.player.framework.net.IdSession;
import com.player.framework.net.MessageRouter;
import com.player.game.messages.login.AccountInfo;
import com.player.game.messages.login.ReqGuestLogin;
import com.player.game.messages.login.ReqUserLogin;
import com.player.game.messages.login.ResGuestLogin;

@Controller
public class LoginController {

    @RequestMapping
    public void reqGuestLogin(IdSession session, ReqGuestLogin request) {
        System.err.println(request.toString());


        ResGuestLogin res = new ResGuestLogin();
        AccountInfo uinfo = new AccountInfo();
        res.setStatus(1);
        uinfo.setId((byte) 1);
        uinfo.setId1((short) 2);
        uinfo.setId2(3);
        uinfo.setUnick("abcdefghijklmnopqrstyvwxyz中文测试0123456789,./[]'*-+");
        res.setUinfo(uinfo);
        MessageRouter.send(session, res);
    }


    @RequestMapping
    public void reqUserLogin(IdSession session, ReqUserLogin request) {
        System.err.println(request.toString());
//		LoginServer.getInstance().reqUserLogin(session, request);
    }

}
