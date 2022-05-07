package com.player.game.message;

import com.alibaba.fastjson.JSONObject;
import com.player.framework.annotation.message.Controller;
import com.player.framework.annotation.message.RequestMapping;
import com.player.framework.net.IdSession;
import com.player.server.message.RespMsg;

@Controller
public class MsgController {

//    @RequestMapping
//    public void resNpcContent(IdSession session, RespMsg request) {
//        session.send(request);
//    }

    @RequestMapping
    public void resNpcContent(IdSession session, ReqChatEx request) {
        System.err.println(JSONObject.toJSONString(request));
//        request.setMsg(request.getMsg()+"#Rtest");
//        request.setOrgLength((short) request.getMsg().getBytes().length);
        session.c_send(request);
        session.send(new RespMsg(request.getMsg()));
//        session.send(new RespMsg("芜湖"));
    }


}
