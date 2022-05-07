package com.player.game.message;

import com.player.framework.annotation.message.Controller;
import com.player.framework.annotation.message.RequestMapping;
import com.player.framework.net.IdSession;

@Controller
public class MsgController {

    @RequestMapping
    public void resNpcContent(IdSession session, RespMsg request) {
        session.send(request);
    }



}
