package com.player.game.server;


import com.player.framework.annotation.message.Controller;
import com.player.framework.annotation.message.RequestMapping;
import com.player.framework.net.IdSession;

@Controller
public class RawController {


    /**
     * 所有未在Module中添加的都会经过这里
     * @param session
     * @param request 该条不能重复
     */
    @RequestMapping
    public void reqNpcTalk(IdSession session, ResRaw request) {
        if(request.get_type()==1){
            session.c_send(request);
        } else if(request.get_type()==2){
            session.send(request);
        }
    }



}
